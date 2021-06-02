package com.spring.rest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.rest.model.Users;

@Service
public class UserServiceImpl implements UserService {

	List<Users> ul=new ArrayList<>();
	
	public UserServiceImpl() {

		ul.add(new Users( 1, "Debajyoti", "India",new ArrayList<String>(
			    Arrays.asList("Buenos Aires", "Córdoba", "La Plata"))));
		
		
	 	ul.add(new Users( 2, "Debajyoti1", "WestBengal",new ArrayList<String>(
			    Arrays.asList("orem Ipsum is", "of the printing ."," Lorem Ipsum has"))));
	 	
		ul.add(new Users( 3, "Debajyoti2", "Asansol", new ArrayList<String>(
			    Arrays.asList("Contrary to popular belief", "Lorem Ipsum is not"," simply random text."))));
		
		ul.add(new Users( 4, "Debajyoti3", "Gopalnagar",new ArrayList<String>(
			    Arrays.asList("It has roots in a", "piece of classical Latin", "literature from 45 BC"))));
		
		ul.add(new Users( 5, "Debajyoti4", "Durgamandir",new ArrayList<String>(
			    Arrays.asList("If you are going to", "use a passage of Lorem Ipsum", "you need to be sure there isn't"))));
		
		
		
	}
	
	@Override
	public List<Users> getUsers() {
		return ul;
	}
	@Override
	public Users getUserById(int id) {
		Users c=null;
		for(Users u : ul) {
			if(u.getId()==id) {
				c= u;
				break;
			}
		}
		return c;
	}

	@Override
	public Users addUser(Users user) {
		// TODO Auto-generated method stub
		this.ul.add(user);
		return user;
	}

	@Override
	public Users updateUser(Users user,int id) {
		for(Users u : ul) {
			if (u.getId()==id) {

				if(user.getName()!=null) {
					u.setName(user.getName());
				}
				if(user.getAddress()!=null) {
					u.setAddress(user.getAddress());
				}
				return u;
			}
		}
		return null;
	}

	@Override
	public String deleteAll() {
		this.ul.clear();
		return "deleted all users";
	}

	@Override
	public String deleteById(int id) {
		int count=0;
		for (Users u: ul) {
			if(u.getId()==id) {
				ul.remove(count);
				return "successfully removed user id "+id;
			}
			count++;
		}
		return null;
	}

	@Override
	public String addPostById(int id, String post) {

		for(Users u: ul) {
			if(u.getId()==id) {
				u.getPosts().add(post);
				return "done";
			}
		}
		return "There might be some problem";
	}
	

}
