Feature: This feature contains all test cases related to search filters

Scenario: Verify jeans filter on Search Result Page of Myntra
	When यूजर लेविस की जीन्स सर्च करेगा
	And user applied Jeans filter on Search Result Page
	Then all results related to jeans should appear

Scenario: This is the demo scenario for myntra homepage
	When यूजर लेविस की जीन्स सर्च करेगा
	And user applied men filter
	Then all resuts related to mens should appear
