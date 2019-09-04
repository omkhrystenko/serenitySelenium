Login

Meta:
@tag login
@tag regression

Narrative
    In order to use app functionality
    As a user
    I want to be able to login

Scenario: Successful user login
Meta:
@tag login01
Given I open Landing page

When I click on 'Sign in' button
Then I should be on Login page


When I sign In as '<email>' , '<password>'
Then Home page is loaded

Examples:
|email                          |password|
|ivanovboris010181@gmail.com    |Qwerty12|

Scenario: Unsuccessfull user login in order to remain on Login page
Meta:
@tag login02
Given I open Landing page

When I click on 'Sign in' button
Then I should be on Login page


Scenario: Login test that will fall to Error page
Meta:
@tag login03
Given I open Landing page

When I click on 'Sign in' button
Then I should be on Login page


When I sign In as '<email>' , '<password>'
Then I should be on Error page
Then I should receive a password error message '<message>'

Examples:
|email                          |password|       message|
|ivanovboris010181@gmail.com    |Qwerty143|      Wrong password|