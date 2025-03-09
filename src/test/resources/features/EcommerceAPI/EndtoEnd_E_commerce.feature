Feature: End to End E-commerce API validation
  Verify the user can able to create a product and order as well as able to delete order and product.

  @Regression
  Scenario:1 Verify the end-end E-commerce APIs
    Given add headers to the API with below details:
      | Content-Type 		|
      | application/json 	|
    When user calls "LoginUser" API with "POST" request:
      | userEmail 	        | password  |
      | postman55@gmail.com | Naidu@117 |
    Then validate the status "200" with below details:
      | message              | userId    | token      |
      | Login Successfully 	 | NotNull#  | NotNull#   |

  @Regression
  Scenario:2
    Given add headers to the API with below details:
      | Authorization 	| Content-Type        |
      | token#       	| multipart/form-data |
    When user calls "CreateProduct" API with "POST" request using form-data:
      | productName | productAddedBy  | productCategory | productSubCategory | productPrice | productDescription | productFor | productImage-file |
      | T-shirt_191 | userId#         | fashion         | shirts             | 1500         | Addias Originals   | women      | Image#            |
    Then validate the status "201" with below details:
      | message                      | productId  |
      | Product Added Successfully 	 | NotNull#   |

  @Regression
  Scenario:3
    Given add headers to the API with below details:
      | Authorization 	| Content-Type     |
      | token#       	| application/json |
    When user calls "CreateOrder" API with "POST" request:
      | country  | productId  |
      | India    | productId# |
    Then validate the status "201" with below details:
      | message                   | productOrderId  | orders[0]     |
      | Order Placed Successfully | NotNull         | NotNull#   |

  @Regression
  Scenario:4
    Given add headers to the API with below details:
      | Authorization 	| Content-Type     |
      | token#       	| application/json |
    And add query parameters to the API with below details:
      | id 		|
      | orders[0]# |
    When user calls "FetchOrderDetails" API with "GET" request
    Then validate the status "200" with below details:
      | message                                  | data.orderById  | data.productOrderedId | data.productName |
      | Orders fetched for customer Successfully | NotNull    | NotNull          | NotNull     |

  @Regression
  Scenario:5
    Given add headers to the API with below details:
      | Authorization 	| Content-Type     |
      | token#       	| application/json |
    And add path parameters to the API with below details:
      | OrderId |
      | orders[0]# |
    When user calls "DeleteOrder" API with "DELETE" request
    Then validate the status "200" with below details:
      | message                     |
      | Orders Deleted Successfully |

  @Regression
  Scenario:6
    Given add headers to the API with below details:
      | Authorization 	| Content-Type     |
      | token#       	| application/json |
    And add path parameters to the API with below details:
      | productId  |
      | productId# |
    When user calls "DeleteProduct" API with "DELETE" request
    Then validate the status "200" with below details:
      | message                      |
      | Product Deleted Successfully |