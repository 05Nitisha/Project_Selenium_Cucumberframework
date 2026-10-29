@searchBus
Feature:Bus search
Scenario:Click Search to search the bus 
Given user is on Home Page
When enters From, To and Date of Journey
Then bus gets searched successfully 