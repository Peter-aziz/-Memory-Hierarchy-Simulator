# Memory Hierarchy Simulator

## Overview

The **Memory Hierarchy Simulator** is a Java-based application designed to simulate the behavior of a memory hierarchy system. It includes components such as a set-associative cache, main memory, and CPU interactions. The simulator provides insights into critical performance metrics like cache hit/miss ratios and Average Memory Access Time (AMAT).

This project was developed as part of the **CSCE 231: Computer Organization and Assembly Language Programming** course at the School of Sciences and Engineering, Department of Computer Science and Engineering, during Spring 2024.

---

## Features

- **Configurable Cache Parameters:** Customize cache size and cache line size for various simulation scenarios.
- **Hit/Miss Analysis:** Visualize the hit/miss ratios and AMAT values.
- **Separate Caches:** Support for separate instruction and data caches (Bonus feature).
- **GUI-Based Interface:** Interactive graphical interface for easy use and visualization.
- **Progress Tracking:** Real-time progress bar and binary conversion for memory accesses.

---

## Installation and Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/Peter-aziz/-Memory-Hierarchy-Simulator.git
   ```

2. Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse) or use command-line tools to compile.

3. Run the main Java class to launch the application:

   ```bash
   java MainClassName
   ```

---

## User Guide

### Step 1: Input Configuration

- Launch the application to open the main GUI window.

- Enter the following parameters:

  - Cache size (in bytes)
  - Cache line size (in bytes)
  - Clock cycles used
  - File paths for data and instruction sequences

- Alternatively, press the **Load** button to use pre-defined values.

### Step 2: Simulate Data Access

- After submitting the configuration, a new window will display the data access simulation.
- Key features:
  - Hit/Miss ratios for the data file
  - AMAT values
  - Binary representation of accessed data
  - Visual progress bar for memory accesses
  - **HIT** or **MISS** indicators in green and red, respectively
  - Restart or Exit buttons for additional control

### Step 3: Simulate Instruction Access

- Repeat the operations performed in Step 2 for the instruction file.
- Separate hit/miss ratios and AMAT values are calculated for instructions.

---

## Design Decisions and Assumptions

1. **Cache Configuration:**

   - Users can customize the cache size and line size to simulate different scenarios.

2. **Replacement Policy:**

   - Implemented Least Recently Used (LRU) policy for cache line replacement.

3. **Memory Addressing:**

   - Assumed a uniform 30-bit memory addressing scheme for simplicity.

---

## Known Bugs or Issues

- The implementation of the Read-Write Cache feature is incomplete. All other features function as expected, and testing has validated the core simulation.

---

## Test Cases and Simulated Sequences

### Simulated Access Sequences:

**Sequence 1:**

```
128, 64, 256, 32, 512, 64, 128, 256, 64, 512, 32, 128, 256, 64, 512, 32, 512, 256, 64, 128
```

**Sequence 2:**

```
112, 128, 104, 400, 378, 140, 38, 40, 90, 23, 22, 10, 89, 67, 83, 12, 49, 200, 403, 160
```

**Data:**

```
200, 220, 240, 260, 200
```

**Instructions:**

```
300, 312, 499, 312, 300
```

---

## Conclusion

The Memory Hierarchy Simulator is a robust educational tool for understanding the functionality and performance of memory hierarchy systems. While there are minor limitations, the simulator delivers a comprehensive and user-friendly experience. It is a valuable resource for students and professionals exploring computer organization concepts.

---

## License

This project is licensed under the MIT License. See the LICENSE file for details.
