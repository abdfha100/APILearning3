Feature: Validate Pet APIs

Scenario: Verify if pet is being added succeffully using AddPet API
Given Add pet payload
When User calls AddPetAPI with POST http request
Then The API call got success with status code 200
