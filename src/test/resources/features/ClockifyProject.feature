@prueba
Feature: Project
  COMO usuario de Clockify
  QUIERO ver los proyectos creados en mi Workspace
  PARA llevar un buen control de mis horas de trabajo y el de mis empleados

  Scenario Outline: Consulta Projects resultado exitoso
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and 'api-key:<key>,workspace:<workspace>'
    And se obtuvo el status code <status>
    Examples:
      | operation | entity  | jsonName                  | status | key                                              | workspace                |
      | GET       | PROJECT | project/rq_params_feature | 200    | NDRmZWUwYzEtOTZhMS00NDk5LWJkZWItY2FiNmY1MjQ3NGNh | 614b795a8fc8f836af59328a |
      | GET       | PROJECT | project/rq_params_feature | 200    | NDRmZWUwYzEtOTZhMS00NDk5LWJkZWItY2FiNmY1MjQ3NGNh | 614b795a8fc8f836af59328a |

  Scenario Outline: Consulta Projects resultado exitoso
    Given Un api-key valido
    And un workspace-id
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And se obtuvo el status code <status>
    Then se muestran los project del perfil
    Examples:
      | operation | entity  | jsonName   | status |
      | GET       | PROJECT | project/rq | 200    |
      | GET       | PROJECT | project/rq | 200    |

  Scenario Outline: Crear un project caso exitoso
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and 'name:<name>'
    And se obtuvo el status code <status>
    And se valida que el project '<name>' fue creado
    Examples:
      | operation | entity  | jsonName               | status | name     |
      | POST      | PROJECT | project/rq_add_project | 201    | Academy9 |

  Scenario Outline: Consulta Project 401 no autorizado
    Given X-Api-Key invalido
    And un workspace-id
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And se obtuvo el status code <status>
    Then se obtuvo el response esperado en <entity> con el <jsonResponse>
    Examples:
      | operation | entity | jsonName   | status | jsonResponse   |
      | GET       | ERROR  | project/rq | 401    | project/rs_401 |

  Scenario Outline: Consulta Workspace resultado erroneo
    Given Un api-key valido
    And un workspace-id '<w-space-id>'
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And se obtuvo el status code <status>
    Then se obtuvo una respuesta vacía
    Examples:
      | operation | entity | jsonName   | status | w-space-id       |
      | GET       | ERROR  | project/rq | 403    | 234jh23bg4j2h3g4 |