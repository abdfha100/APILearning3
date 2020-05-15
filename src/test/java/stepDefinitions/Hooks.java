package stepDefinitions;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePet")
	public void beforeScenario() throws Exception
	{
		//write a code that will give you the place id
		//execute this code only when the place id is null
		
		StepDefinition sd = new StepDefinition();
		
		if(StepDefinition.petId==null)
		{
			sd.add_pet_payload_with(670 , "Chameli");
			sd.user_calls_with_http_request("AddPetAPI", "POST");
			sd.verify_petId_created_maps_to_using("Chameli", "GetPetAPI");
		}
	}
}
