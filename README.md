# password-validator

This is a challenge from https://github.com/itidigital/backend-challenge. For this challenge, you should use /v1/api/password/validator to test API.

## Endpoints

### Swagger
you can test via Swagger: http://localhost:8080/swagger-ui.html

### Operations
| request methods | endpoint                           | input type | example                    | description       |
|-----------------|------------------------------------|------------|----------------------------|-------------------|
| `POST`          | `/v1/api/password/validator`       | `password` | {"password": "AbTp9 !fok"} | pasword validator |

### Curl
```bash
curl -X 'POST' \
'http://localhost:8080/v1/api/password/validator' \
-H 'accept: */*' \
-H 'Content-Type: */*' \
-d '{
"password": "AbTp9 !fok"
}'
```

## Business Rule
I received the challenge with password validator that should be the following business rules
1. digit
2. lettercase
3. uppercase
4. special character "!@#$%^&*()-+"
5. Not having repeated characters within the set

and provided some tests
```
IsValid("") // false  
IsValid("aa") // false  
IsValid("ab") // false  
IsValid("AAAbbbCc") // false  
IsValid("AbTp9!foo") // false  
IsValid("AbTp9!foA") // false
IsValid("AbTp9 fok") // false
IsValid("AbTp9!fok") // true
```
First, 
I thought and test some conditions below with regex function:
* a-z lowercase and in sequence
* A-Z uppercase and in sequence
* special characters "!@#$%^&*()+-"
* min 9 characters
```kotlin
Pattern.matches("[a-zA-Z0-9!@#$%^&*()+-]{9,}", password)
```

Second,
I check if replacing a character to empty value modifies the string length. If a set have 2 characters in different positions, I will decrease length by 2 values.
```kotlin
password.password.length != password.password.replace(c.toString(), "").length + 1
```

Third,
I tried to encapsulate all the conditions from the business rules in 4 classes.
* DigitCase
* LowerCase
* SpecialCase
* UpperCase

All validate it business rule and, if true, add a position in its case.
Example:
```kotlin
override fun isValid(password: Password, value: Char) =
    value.toString().matches(Regex("[0-9]")).let { if (it) password.digit += 1 }
```

Finally,
I validate that all business rules are ok.
```kotlin
uppercase > 0 && lowercase > 0 && special > 0 && digit > 0
```

To confirm and with the need for some code refactoring, I needed to create unit tests and integration tests.
* DigitCaseTest (unit test)
* LowerCaseTest (unit test)
* SpecialCaseTest (unit test)
* UpperCaseTest (unit test)
* PasswordServiceTest (unit test) 
* PasswordValidatorIT (integration test)

## Technologies
I preferred make this test with Spring WebFlux + Coroutines + DSL. These are essential to allow the evolution of the code very easily. Main Layers:
* Router: provides a concise and fluent way to define endpoints 
* Handler: important classes for mapping HTTP code with requests to specific business rules
* Service: main classes to business rules


## Installation

### Requirements
- Java 17 or newer
- Maven 3.3.1 or newer

### Run by maven

```bash
user@pc:~/password-validator$ mvn clean package
user@pc:~/password-validator/target$ java -jar password-validator.jar
```

### Run by exec.sh
To facilitate executions I created a `exec.sh` file with the boilerplate commands.<br />
To execute given `sh` file, do the following `chmod +x exec.sh` command, after that it's ready to run, just pass the
proper parameters, any doubts just run the command `./exec.sh --help`.

#### more details

Uso:`user@pc:~/password-validator$$ ./exec.sh [OPTION]`
```bash
user@pc:~/password-validator$ ./exec.sh run               Execute docker command to create password-validator image and run using 8080 port
```

#### manual commands

- `docker build -t password-validator .` to create the docker image `password-validator`
- `docker run --rm password-validator` run the docker image