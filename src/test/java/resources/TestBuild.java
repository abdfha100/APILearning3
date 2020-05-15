package resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pojo.M1PostPet;
import pojo.M2Category;
import pojo.M3Tag;


public class TestBuild {
	
	public M1PostPet addPetPayload(int id, String name)
	{
		M1PostPet m1pp = new M1PostPet();
		m1pp.setId(id);
		m1pp.setName(name);
		m1pp.setStatus("available");
		
		M2Category m2c = new M2Category();
		m2c.setId(5);
		m2c.setName("categoryA");
		m1pp.setCategory(m2c);
		
		M3Tag m3t = new M3Tag();
		m3t.setId(7);
		m3t.setName("tagABC");
		
		List<String> list = new ArrayList<String>();
		list.add("string");
		m1pp.setPhotoUrls(list);
		return m1pp;
	}
}
