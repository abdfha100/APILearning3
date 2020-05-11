package petAPI;

import java.util.ArrayList;
import java.util.List;

public class TestBuild1 {
	
	public M1PostPet getPePostPayload()
	{
		M1PostPet m1pp = new M1PostPet();
		m1pp.setId(7010);
		m1pp.setName("dog123");
		m1pp.setStatus("available");
		
		M2Category m2c = new M2Category();
		m2c.setId(5);
		m2c.setName("categoryA");
		m1pp.setCategory(m2c);
		
		M3Tag m3t = new M3Tag();	
		m3t.setId(7);
		m3t.setName("tagABC");
		m1pp.setTags(m3t);
		
		List<String> list = new ArrayList<String>();
		list.add("string");
		m1pp.setPhotoUrls(list);
		return m1pp;
	}

}
