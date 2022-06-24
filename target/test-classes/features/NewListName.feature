#Author: your.email@your.domain.com
Feature: Add new to do list header
  I want to use this template for my feature file

  Scenario: Input list name
    Given User at Main Activity
    When User tap add list name button
    And User input list name alphabet "Bootcamp Test"
    Then User validate list name
    And New list name showed in header

  Scenario: Input list name
    Given User at Main Activity
    When User tap add list name button
    And User input list name number "08951234"
    Then User validate list name
    And New list name showed in header

  Scenario: Input list name
    Given User at Main Activity
    When User tap add list name button
    And User input list name symbol "!@#$%^&"
    Then User validate list name
    And New list name showed in header

  Scenario: Input list name
    Given User at Main Activity
    When User tap add list name button
    And User input list name special char "📅📅📅"
    Then User validate list name
    And New list name showed in header

  Scenario: Input list name
    Given User at Main Activity
    When User tap add list name button
    And User input empty field ""
    Then User validate list name
    And User cancel list name
    And New list name not showed in header
