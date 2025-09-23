Feature: Parameterization Demo


#Scenario: Passing parameter to the step
#	Given I have two numbers 15 and 62
#	When I add them
#	Then print the result
	
#Scenario: Passing word and string to the step
#	Given I have an "Mango"
#	And I have its quantity as 10
#	Then print "My name is Avinash"

#Scenario: Passing list to the scenario
#	Given I have following fruits:
#		|Apple|10|12|
#		|Banana|12|
#		|Mango|3|
#		|Grape|100|
#		|Guava|20|
#		|Pineapple|15|		
#	Then print the entire list

@Regression @Smoke
Scenario Outline: This is first data driven scenario
	Given I have a fruit <fruit-name>
	And its quantity as <qty>
	Then print the fruit name and its quantity
	
Examples: 
	|fruit-name|qty|
	|Apple|10|
	|Mango|12|
	|Pineapple|3|
	|Strawberry|40|
	|Guava|8|
	|Fig|200|

@this
Scenario Outline: Accept data from excel
	Given I have a <promo-code>
	Then print the promocode
	
Examples:
	|promo-code|
	|1|
	|2|
	|3|
	|4|
	|5|
	|6|
	|7|
	|8|
	|9|
	|10|
	|11|
	|12|
	|13|
	|14|
	|15|
	|16|
	|17|
	|18|
	|19|
	|20|
	




















	
	