package resources;

//enum is a special class in java which has collection of constants or methods

public enum APIResources {
	
	AddPetAPI("/v2/pet/"),
	GetPetAPI("/v2/pet/"),	
	DeletePetAPI("/v2/pet/");
	
	private String resource;
	
	APIResources(String resource)
	{
		this.resource = resource;
	}
	
	public String getResource()
	{
		return resource;
	}
}
