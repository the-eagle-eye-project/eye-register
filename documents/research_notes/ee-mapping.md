# ElasticSearch Mapping Search Points

`NOTE: Field mapping options, cannot be changed once created or added to the index.`

### Explicit Mapping

We define the fields of the mapping ourselves.

### Dynamic Mapping

ElasticSearch generates the field mapping for us, when encountered.

## Coerce

Coerce is a property in ElasticSearch defined either at the index level or at the attribute
level, that if enabled, values will be able to be stored different that their own datatype. For
example `"price" : 7.5` and `"price" : "7.5"` will be stored in the index without any exception.
However, if disabled, then when saving into the index with an incorrect datatype, it will throw
and exception.

Disable coerce at index level:

```json
{
  "settings": {
    "index.mapping.coerce": false
  }
}
```

Disable coerce at attribute level:

```json
{
  "email": {
    "type": "keyword",
    "coerce": false
  }
}
```

## Data-types

### Text

The text datatype, internally when the data is stored in the inverted index, it will remove
all kind of symbols, punctuations, and others. This is so that when it get to the Inverted
Index, the data gets classified only with letters and words.

### Keyword

The keyword datatype, will store the text as it comes in the request, including symbols. This is
mostly used on fields like `email`, where we want to hold at the `@` for search purposes.

### Date

The date data-type is used to store dates. However if not setup correctly, you could end up saving data
that in the wrong format. You can have dates with `YYYY-MM-DD`, `YYYY-MM-DDTHH:MI:SS.SSSZ` or EPOCH with
stored as `Long`. In the background, Lucene will store all dates as EPOCH.
<br><t><br><t>`NOTE: EPOCH is the amount of milliseconds since January 1st, 1970`

