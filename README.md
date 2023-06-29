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
  ```
  # Query to create the logs index in ES
  PUT logs
  {
    "mappings": {
      "properties": {
        "transaction_id": {
          "type": "text"
        },
        "application_name": {
          "type": "text"
        },
        "application_step": {
          "type": "text"
        },
        "event_timestamp": {
          "type": "date"
        },
        "request_body": {
          "type": "text"
        },
        "request_uri": {
          "type": "text"
        },
        "source_host": {
          "type": "text"
        },
        "transaction_status": {
          "type": "text"
        }
      }
    }
  }
  ```
- **app_meta** -> will contain the metadata of the applications that will be monitored
  by Eagle Eye. Each configuration will contain variues attributes describing the behavior
  of an application and if there is any relationship to another application.

## Engine

The Eagle Eye Engine is in charge of consume the logs and log alerts in case an anomaly
in a system is detected. The engine will run based on the consumer configurations. Both
batch and realtime monitor jobs will perform the same functionalities, however they will
run based on where the use of schedule, or when an event is triggered.

### Batch Monitor [TODO: Add design diagrams]

### Realtime Monitor [TODO: Add design diagrams]

## Eagle Eye Client

## Metadata Registry

The Metadata registry APIs register different transactions as Consumers, Providers or Intermediates. This
will enable logs to get to ElasticSearch for further consumption.

**IMPORTANT**: If an application sends data to other applications based on the data that it's been process, as of the
first version of this product, each datapoint that goes into different apps, should be registered as a different
integration, so that tracking of those transactions are accurate.