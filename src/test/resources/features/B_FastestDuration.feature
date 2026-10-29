@findFastestBus
Feature:Sorting as Fastest First
Scenario:click Fastest first to Sort
Given user is on Home Page
When enters From, To and Date of Journey
Then bus gets searched successfully 
Given user is on Bus List screen
When click on Fastest First option
Then Bus list appears sorted with Fastest First