# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Java SDK for consuming SW sapien® web services for Mexican electronic invoicing (CFDI 4.0). Built for Java 1.8+ with Maven.

## Build Commands

```bash
# Build project
mvn clean install

# Build with dependencies jar
mvn clean package

# Run all tests
mvn test

# Run a single test class
mvn test -Dtest=StampTest

# Run a single test method
mvn test -Dtest=StampTest#testStampV1

# Skip tests
mvn install -DskipTests

# Check code style
mvn checkstyle:check

# Format code (Google Java Format)
mvn spotless:apply
```

## Test Configuration

Tests require environment variables:
- `SDKTEST_USER` - SW account email/user
- `SDKTEST_PASSWORD` - SW account password
- `SDKTEST_TOKEN` - SW infinite token

Test resources are in `resources/` directory, including sample XML/JSON CFDIs and test certificates.

## Architecture

### Core Classes

- **`Services`** (`mx.com.sw.services.Services`) - Base class for all services. Handles authentication and token management with automatic renewal.

- **`ResponseHandler`** (`mx.com.sw.services.ResponseHandler`) - HTTP client layer using Apache HttpClient. All API calls go through here.

### Service Pattern

Each service follows a consistent pattern:
```
services/<service-name>/
├── <ServiceName>.java           # Public API class
├── <ServiceName>Service.java    # Internal service implementation
├── <ServiceName>Validation.java # Input validation (optional)
├── requests/                    # Request DTOs
└── responses/                   # Response DTOs + ResponseHandler
```

### Main Services

| Service | Package | Description |
|---------|---------|-------------|
| Authentication | `authentication` | Get auth tokens |
| Stamp | `stamp` | Stamp sealed CFDIs |
| Issue | `issue` | Seal and stamp CFDIs |
| Cancelation | `cancelation` | Cancel CFDIs |
| StatusCfdi | `StatusCfdi` | Check CFDI status |
| Validate | `Validate` | Validate XML structure |
| AcceptReject | `acceptreject` | Accept/reject cancellations |
| Pdf | `pdf` | Generate PDFs from CFDIs |
| Relations | `relations` | Get related CFDIs |
| Pendings | `pendings` | Get pending cancellations |
| Csd | `csd` | Manage CSD certificates |
| Account | `account/balance`, `account/info` | Account management |

### Authentication Modes

Services support two authentication modes:
1. **User/Password** - Automatically obtains and renews tokens
2. **Infinite Token** - Uses pre-generated token

### API Endpoints

- Test: `https://services.test.sw.com.mx` (stamping), `https://api.test.sw.com.mx` (services)
- Production: `https://services.sw.com.mx`, `https://api.sw.com.mx`

## Testing Helpers

`BuildSettings` (`src/test/java/mx/com/sw/helpers/BuildSettings.java`) provides:
- Pre-configured URLs and test credentials from env vars
- Sample CFDI generation with automatic date/folio updates
- Certificate loading utilities
- Methods: `getCFDI(signed)`, `getJsonCFDI()`, `getCFDIB64(signed)`
