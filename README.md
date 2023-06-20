# eagle-eye

The purpose of this repository is to develop and maintain the open source Eagle Eye project.

# High Level Design

![High Level Design](./documents/ee-design.png)

## Elastic Search Indexes

- **alert_logs** -> contain all the alerts raised based on the engine monitor
  jobs. This jobs either run in a batch job or real time. This will be based on the
  configuration created by the consumer
- **event_logs** -> these are logs that will be use to monitor a single event on one
  or across multiple applications hosted in different environments.
- **app_meta** -> will contain the metadata of the applications that will be monitored
  by Eagle Eye. Each configuration will contain variues attributes describing the behavior
  of an application and if there is any relationship to another application.