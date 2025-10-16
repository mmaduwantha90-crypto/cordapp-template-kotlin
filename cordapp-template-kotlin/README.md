# Corda Patient Management System

This project is a Corda application designed for managing patient records. It includes flows for creating patient states, contracts for enforcing business rules, and state definitions for representing patient data on the ledger.

## Project Structure

- **workflows/src/main/kotlin/com/template/flows/CreatePatientFlow.kt**: Contains the `CreatePatientFlow` class, which is responsible for creating a new patient record in the Corda ledger.
  
- **contracts/src/main/kotlin/com/template/contracts/PatientContract.kt**: Defines the `PatientContract` class, which includes the contract logic for managing patient states, including commands like `Create`.

- **states/src/main/kotlin/com/template/states/PatientState.kt**: Represents the state of a patient in the Corda ledger, including properties such as `patientId`, `name`, `address`, `contact`, `timestamp`, and `owner`.

## Build Instructions

To build the project and create a JAR file, use the following command:

```bash
./gradlew build
```

This will compile the Kotlin code, run tests, and package the application into a JAR file.

## Usage

1. Start a Corda node.
2. Use the Corda shell or RPC to initiate the `CreatePatientFlow` with the required parameters (name, address, contact).
3. The flow will generate a unique patient ID and store the patient record on the ledger.

## Requirements

- Java 8 or higher
- Gradle 6.0 or higher

## License

This project is licensed under the MIT License. See the LICENSE file for more details.