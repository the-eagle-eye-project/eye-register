# Search Mapping Options

## Norms

Used for relevance scoring, which will rank the results for best match. Norms should be disable
for fields we are not using for searching and not going to impact the relevance or sorting.
Disabling Norms will help reducing Disk space.

Example of disabling:

```json
PUT /products
{
  "mappings": {
    "properties": {
      "tags": {
        "type": "text",
        "norms": false
      }
    }
  }
}
```

## Index Parameter

It is used and set to false when we know that the field will not be used for performing
a search. The field will still show in `_source`. Saves disk space and slightly will increase
the indexing performance. Even when disable, you can still use the field for aggregations.

```json
PUT /products
{
  "mappings": {
    "properties": {
      "tags": {
        "type": "text",
        "index": false
      }
    }
  }
}
```

## NULL Values

Null values can not be indexed or searched.

## Copy To

Option `copy_to` parameter, let you merge multiple fields into one. For example `first_name` and
`last_name` into `full_name`. Only values will be copied, not the tokens or analizer properties.
The copy values will not be part of the `_source` object.