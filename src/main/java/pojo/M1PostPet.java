package pojo;

import java.util.Collection;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public M2Category getCategory() {
		return category;
	}
	public void setCategory(M2Category category) {
		this.category = category;
	}
	public List<String> getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}

}
 