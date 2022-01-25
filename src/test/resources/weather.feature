Feature: weather forecast

  Scenario: Weather for specific city
    Given city name is "Cairns"
    And country name is "AU"

    When we are requesting weather data

#    Then lon is 145.77
#    And lat is -16.92

    Then coordinates are:
      | lon | 145.77 |
      | lat | -16.92 |

    # And.....

    And weather is edited with following fields:
      | id  | main     | description        | icon  |
      | 802 | "Clouds" | "scattered clouds" | "03n" |

    And main info is:
      | temp     | 300.15 |
      | pressure | 1007   |
      | humidity | 74     |
      | temp_min | 300.15 |
      | temp_max | 300.15 |

   # And temp is 300.15
    #And pressure is 1007
    #And humidity 74
    #And min temp 300.15
    #And max temp 300.15

    # And .....

    And base is "stations"
    And visibility is 10000
    And wind conditions is:
      | speed | 3.6 |
      | deg   | 160 |
    And clouds condition is 40
    And dt is 1485790200
    And sys data are:
      | type    | 1          |
      | id      | 8166       |
      | message | 0.2064     |
      | country | "AU"       |
      | sunrise | 1485720272 |
      | sunset  | 1485766550 |
    And id is 2172797
    And city name is "Cairns"
    And cod is 200



