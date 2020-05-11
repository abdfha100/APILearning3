package pojo;

import java.util.HashMap;
import java.util.List;

public class M1PostPet {
	private int id;
	private String name;
	private String status;
	private M2Category category ;
	private List<String> photoUrls;
	private M3Tag tags;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public M2Category getCategory() {
		return category;
	}
	public void setCategory(M2Category category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}
	public M3Tag getTags() {
		return tags;
	}
	public void setTags1(M3Tag m3t) {
		this.tags = m3t;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setTags(M3Tag m3t) {
		// TODO Auto-generated method stub
	}
}
 