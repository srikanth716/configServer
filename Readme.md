## Configuration of Spring Cloud Config Server
API http://localhost:8888/{application-name}/{profile}

The Config Server will fetch both `application-{profile}.properties` and `{application-name}-{profile}.properties`.

#### Example

Example: http://localhost:8888/mimoto/default


Response includes both ```mimoto-default.properties``` and ```application-default.properties```,


# `spring.profiles.active`

## spring.profiles.active: composite (server)
The active profile is set to composite, enabling the use of multiple configuration sources.

## spring.profiles.active:default (client)
The `spring.profiles.active` property is defined in the `mimoto-default.properties` file. This property is typically used to specify which profiles are active for the application. However, according to Spring Boot's configuration conventions, `spring.profiles.active` should not be defined in profile-specific property files like `mimoto-default.properties`.

#### Solution

Remove `spring.profiles.active` from `mimoto-default.properties`: Ensure that `mimoto-default.properties` only contains configurations relevant to the default profile without defining `spring.profiles.active`.

## Priority Order

1. Git repository properties are prioritized first.
2. Files from the local filesystem are considered next.
3. Properties from Vault are the lowest priority.

Adjust the order in the composite list to set the desired priority. The first item in the list has the highest priority, and the last item has the lowest priority.