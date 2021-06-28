# map-project

Goal : creation of small web-based application that will be able to present data on map and receive configuration from relation DB.
Technologies to be used:
◆ Front-end - JavaScript, HTML5, CSS3
◆ Backend – Java, Spring framework, in-memory relational DB
Use case:
◆
As an application user I have to open my map view with the list of available locations in default area:
- When I open application, I see the main view with menu and map
centered to Ukraine best fit
- The menu should contain list of cities where locations located grouped by city name (i.e. if we store 3 location within same city only one city
element should be in the list)
◆
As an application user I should have reset map view button
- In case I change view (zoom in\out, move to another country, etc) I
should be able to reset map to default view (opened during application
load)
◆
As an application user I should be able to click on city menu item and locate to point within that city with zoom level required to view other locations within that area 
◆
As an application user I should be able to zoom-in/out on the map by one of two options – buttons on the map or mouse wheel scroll
◆
As an system integrator I should be able to store following data in DB:
- Location (city, long, lat, address, address details)
- The DB schema should be normalized and have no duplicates of city
names
- Address details should be a varchar field that allow to store additional
information for asset like company name, name of the building