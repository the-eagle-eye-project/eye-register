# Index Template

It is used to create templates or setting across multiple index patterns. This is useful when you have multiple
indexes that have the same properties, or indexes that are getting created as soon as they hit a date, size or other
property target. This simplifies the automation and creation of new indexes.

Example of an index template:

```json
PUT /_template/access-logs
{
  "index_patterns": ["access-logs-*"], 
  "settings": {
    "number_of_shards": 2,
    "index.mapping.coerce" : false
  }, 
  "mappings": {
    "properties": {
      "@timestamp" : {
        "type" : "date"
      },
      "url.original" : {
        "type": "keyword"
      },
      "http.request.referrer" : {
        "type": "keyword"
      },
      "http.response.status_code" : {
        "type": "long"
      }
    }
  }
}

# Creates a new index based on the _template configurations
PUT /access-logs-2020-01-01

# Retrieves the index properties
GET /access-logs-2020-01-01
```

## Elastic Common Schema (ECS) 
Defines common fields and its properties between multiple indexes. This fields are specified by Elastic Stack, to make
sure there is a common knowledge about them. Also, helps to make sure that the field definition or name doesn't change 
across time, since it could create issues for downstream processing, like Kibana consuming log data. This fields are 
documented in the following website: https://www.elastic.co/guide/en/ecs/current/index.html

Some examples of these fields are:
```json
{
  "http.request.body.bytes" :{
    "type" : "long"
  },
  "geo.country_name" :{
    "type" : "long"
  },
}
```