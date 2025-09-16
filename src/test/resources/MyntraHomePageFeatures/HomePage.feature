Feature: This feature contains all test cases related to search filters

Scenario: Verify jeans filter on Search Result Page of Myntra
	Given browser is opened and myntra url is launched
	When यूजर लेविस की जीन्स सर्च करेगा
	And user applied Jeans filter on Search Result Page
	Then all results related to jeans should appear

Scenario: Second Scenario
