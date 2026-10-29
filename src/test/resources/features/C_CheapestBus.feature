@findCheapestBus
Feature:Sorting as Cheapest First
Scenario:click Cheapest first to Sort
Given user is on Home Page
When enters From, To and Date of Journey
Then bus gets searched successfully 
Given user is on  List screen
When click on Cheapest First option
Then Bus list appears sorted with Cheapest First