package com.basho.riak.client.jiak;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.json.JSONException;
import org.junit.Test;

import com.basho.riak.client.util.ClientUtils;
import com.basho.riak.client.util.Constants;

public class TestJiakBucketInfo {

    final String FIELD1 = "f1"; 
    final String FIELD2 = "f2"; 
    final List<String> FIELD_LIST = Arrays.asList(FIELD1, FIELD2);

    JiakBucketInfo impl = new JiakBucketInfo();

    @Test public void allowed_fields_sets_schema() throws JSONException {
        impl.setAllowedFields(FIELD_LIST);

        List<String> fields = ClientUtils.jsonArrayAsList(impl.getSchema().getJSONArray(Constants.JIAK_FL_SCHEMA_ALLOWED_FIELDS));
        assertTrue(fields.contains(FIELD1));
        assertTrue(fields.contains(FIELD2));
    }
    
    @Test public void null_allowed_fields_translates_to_wildcard() throws JSONException {
        impl.setAllowedFields(null);
        assertEquals("*", impl.getSchema().getString(Constants.JIAK_FL_SCHEMA_ALLOWED_FIELDS));
    }
    
    @Test public void null_allowed_fields_element_doesnt_throw_exception() {
        final List<String> ALLOWED_FIELDS = Arrays.asList((String) null);
        impl.setAllowedFields(ALLOWED_FIELDS);
    }
    
    @Test public void get_allowed_fields_returns_allowed_fields() {
        
    }

    @Test public void get_allowed_fields_returns_null_for_wildcard_or_null() {
        
    }

    @Test public void required_fields_sets_schema() throws JSONException {
        impl.setRequiredFields(FIELD_LIST);

        List<String> fields = ClientUtils.jsonArrayAsList(impl.getSchema().getJSONArray(Constants.JIAK_FL_SCHEMA_REQUIRED_FIELDS));
        assertTrue(fields.contains(FIELD1));
        assertTrue(fields.contains(FIELD2));
    }

    @Test public void null_required_fields_translates_to_empty_list() throws JSONException {
        impl.setRequiredFields(null);
        assertEquals(0, impl.getSchema().getJSONArray(Constants.JIAK_FL_SCHEMA_REQUIRED_FIELDS).length());
    }

    @Test public void get_required_fields_returns_required_fields() {
        
    }

    @Test public void get_required_fields_returns_empty_list_for_null() {
        
    }
    
    @Test public void write_mask_sets_schema() throws JSONException {
        impl.setWriteMask(FIELD_LIST);

        List<String> fields = ClientUtils.jsonArrayAsList(impl.getSchema().getJSONArray(Constants.JIAK_FL_SCHEMA_WRITE_MASK));
        assertTrue(fields.contains(FIELD1));
        assertTrue(fields.contains(FIELD2));
    }

    @Test public void null_write_mask_translates_to_wildcard() throws JSONException {
        impl.setWriteMask(null);
        assertEquals("*", impl.getSchema().getString(Constants.JIAK_FL_SCHEMA_WRITE_MASK));
    }

    @Test public void get_write_mask_returns_write_mask() {
        
    }

    @Test public void get_write_mask_returns_null_for_wildcard_or_null() {
        
    }

    @Test public void read_mask_sets_schema() throws JSONException {
        impl.setReadMask(FIELD_LIST);

        List<String> fields = ClientUtils.jsonArrayAsList(impl.getSchema().getJSONArray(Constants.JIAK_FL_SCHEMA_READ_MASK));
        assertTrue(fields.contains(FIELD1));
        assertTrue(fields.contains(FIELD2));
    }

    @Test public void null_read_mask_translates_to_wildcard() throws JSONException {
        impl.setReadMask(null);
        assertEquals("*", impl.getSchema().getString(Constants.JIAK_FL_SCHEMA_READ_MASK));
    }

    @Test public void get_read_mask_returns_read_mask() {
        
    }

    @Test public void get_read_mask_returns_null_for_wildcard_or_null() {
        
    }
}
