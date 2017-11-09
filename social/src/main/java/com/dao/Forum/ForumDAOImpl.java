package com.dao.Forum;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import com.model.*;

@Repository
public class ForumDAOImpl implements ForumDAO {
	
	//private static final Logger log=LoggerFactory.getLogger(UserDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	ForumDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	

	public Forum createForum(String fname ,String fdata,List members,String uid){
		try{
			Forum f= new Forum();
			f.setForumData(fdata);
			f.setForumName(fname);
			f.setForumCreatorID(uid);
			f.setLastUpdateDate(new Date());
			sessionFactory.getCurrentSession().save(f);
			Forum f1=(Forum) sessionFactory.getCurrentSession().load(Forum.class,  f.getForumID());
			for(int i=0;i<members.size();i++){
				Members m= new Members();
				m.setForumID(f1.getForumID());
				m.setMemberId((String) members.get(i));
				f1.getForumMembers().add(m);
				System.out.println(	members.get(i));
			}

			
			return f1;
		}
		catch(Exception e){
			System.err.println(e);
			return null;
		}

	}

	public Forum getForumById(int ForumID) {
		return  (Forum) sessionFactory.getCurrentSession().get(Forum.class, ForumID);
	}

	public List<Forum> getAllForum(String uid) {
		//return sessionFactory.getCurrentSession().createQuery("from Forum").list();
		String sql="select forumID,forumName,forumData,lastUpdateDate,forumCreatorID from Forum where ForumCreatorID = '"+uid+"' or ForumID  in(select ForumId from Forum_Members where memberId='"+uid+"')";
		 
		List<Object> list=sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		List<Forum> returnList=new ArrayList<Forum>();
		Forum f;
		for(int i=0;i<list.size();i++){
			f=new Forum();
			Object[] obj=(Object[]) list.get(i);
			int id=Integer.parseInt(obj[0].toString());
			f.setForumID(id);
			
		f.setForumName((String) obj[1]);
	f.setForumData((String) obj[2]);
	
			f.setLastUpdateDate((Date) obj[3]);
			f.setForumCreatorID( obj[4].toString());
			System.out.println(f.getForumCreatorID());
			returnList.add(f);
			
		}
		System.out.println(""+returnList.size());	
		return returnList;
		
	}

	public List<Members> getMembers(int ForumID) {
		Forum forum =getForumById(ForumID);
		return forum.getForumMembers();
	}

	

}
