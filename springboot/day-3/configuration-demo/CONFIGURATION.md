# Externalized Configuration

## Configuration sources

The application uses `src/main/resources/application.yml` for defaults. Environment variables and command-line arguments can override those defaults.

## Configuration classes

- `MailProperties` binds `app.mail`.
- `StorageProperties` binds `app.storage`.

## Annotations used

`@ConfigurationProperties`, `@ConfigurationPropertiesScan`, `@Validated`, `@NotBlank`, `@NotEmpty`, `@Min`, `@Max`, `@Email`, and `@Value`.

## Configuration precedence

For the sources demonstrated here, command-line arguments take precedence over environment variables, which take precedence over `application.yml`.

Examples:

```text
APP_MAIL_HOST=mail.company.com
APP_MAIL_PORT=2525
APP_STORAGE_LOCATION=D:/uploads
APP_STORAGE_MAX_FILE_SIZE_MB=25
```

```text
--app.mail.host=smtp.test.com --app.mail.port=465 --app.storage.location=./cli-uploads --app.storage.max-file-size-mb=50
```

## Validation

Startup validation rejects a blank mail host, a mail port outside 1–65535, an invalid sender email, a blank storage location, a storage size below 1 MB, or an empty allowed-extension list.

## Verification

Run `./mvnw test` (or `mvnw.cmd test` on Windows). The test suite exercises both REST endpoints and their YAML-bound response values. Live checks confirmed both endpoints return the defaults, environment variables override all four demonstrated properties, and command-line arguments override all four demonstrated properties. Startup was also checked with an out-of-range mail port, blank mail host, zero storage size, and empty extension list; each invalid configuration failed validation.

## Conclusion

This application demonstrates externalized configuration, typed property binding, validation, environment and command-line overrides, REST endpoints, and individual `@Value` injection.

## Assignment completion

**14/14 complete.** The standalone Maven project, dependencies, YAML defaults, property classes, scanning, service, controller, `@Value` demo, endpoint checks, environment override, command-line override, validation checks, and this documentation are in place.
