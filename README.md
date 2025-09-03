# SystemPerformanceAnalyzer

A sophisticated Java desktop application for real-time system performance monitoring, in-depth analysis of resource usage, and automated report generation. Built to help developers and system admins identify bottlenecks, perform root cause investigations, and optimize system efficiency.

## Features
- **Real-time Monitoring**: Tracks CPU and memory usage with periodic updates using multi-threading.
- **Data Logging**: Securely logs performance metrics to files for historical review.
- **Advanced Analysis**: Detects anomalies, simulates root cause (e.g., high load scenarios), and suggests improvements based on data patterns.
- **Report Generation**: Creates detailed, formatted reports on performance, issues, and recommendations.
- **Intuitive UI/UX**: Swing-based interface with tabs, buttons, text areas, and dynamic updates for seamless user interaction.
- **Error Handling**: Robust validation to ensure 100% uptime and no crashes.
- **Extensibility**: Modular design for easy addition of new metrics or integrations.

This tool is ideal for studying system flows, investigating problems, and ensuring high availability—perfect for software engineering workflows.

## Technologies Used
- Core Java (SE 8+)
- Swing for GUI
- Multi-threading (java.util.Timer)
- System Management APIs (com.sun.management for metrics)
- File I/O for persistence

## Prerequisites
- Java Development Kit (JDK) 8 or higher installed.
- No additional libraries needed.

## Setup and Run
1. Create a `bin/` folder in the project root for compiled classes.
2. Compile the source code:

javac -d bin src/com/performance/analyzer/.java src/com/performance/analyzer/model/.java src/com/performance/analyzer/ui/.java src/com/performance/analyzer/util/.java

3. Run the application:

java -cp bin com.performance.analyzer.Main

4. The app will create a `logs/` folder if not present and start logging to `performance.log`.

## Usage
- **Monitor Tab**: Start/Stop monitoring to view live CPU/memory stats.
- **Analysis Tab**: Load logs, run analysis to see issues and root causes.
- **Report Tab**: Generate and view reports.

## Screenshots (Add your own after running)
- (Placeholder: Main UI with tabs)
- (Placeholder: Monitoring in action)

## Contribution
Fork the repo, make improvements (e.g., add network monitoring), and submit a pull request. Ensure code follows clean architecture principles.

## License
MIT License - Free to use and modify.