Feature: Validate Pet APIs

@AddPet @Regression @Smoke
Scenario Outline: Verify if pet is being added succeffully using AddPet API
Given Add pet payload with <id> "<name>"
When User calls "AddPetAPI" with "POST" http request
Then The API call got success with status code 200
And "status" in the response body is "available"
And verify petId created maps to "<name>" using "GetPetAPI"

Examples:
	|id   |name|
	|555  |German Shepherd|
	#|556  |Labrador|
	#|557  |Beagle|
	
@DeletePet @Regression
Scenario: Verify if Delete PetAPI functionality is working
 Given DeleltePetAPI paylod
 When User calls "DeletePetAPI" with "Delete" http request
 Then The API call got success with status code 200
	