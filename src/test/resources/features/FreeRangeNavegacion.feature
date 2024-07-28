Feature: Navbar navigation
  Me permite navegar a todas las opciones
  Without login
  Puedo hacer click en los links

  Scenario Outline: I can access the subpages through the navigation bar
    Given I navigate to www.freerangetesters.com
    When I Go to a <section> using the navigation bar
    Examples:
      | section   |
      | Cursos    |
      | Recursos  |
      | Blog      |
      | Mentorías |
      | Udemy     |

  Scenario: Courses are presented correctly to potential cutomers
    Given I navigate to www.freerangetesters.com
    When I Go to a Cursos using the navigation bar
    And select Introduction al testing

  Scenario: Users can Select a plan when signin up
    Given I navigate to www.freerangetesters.com
    When I select elegir un plan
    Then I can validate the options in the checkout page