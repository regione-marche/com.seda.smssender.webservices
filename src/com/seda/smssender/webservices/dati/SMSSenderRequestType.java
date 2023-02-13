/**
 * SMSSenderRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.seda.smssender.webservices.dati;

public class SMSSenderRequestType  implements java.io.Serializable {
    private java.lang.String SMSEDataTOList;

    private java.lang.String SMSDataText;

    public SMSSenderRequestType() {
    }

    public SMSSenderRequestType(
           java.lang.String SMSEDataTOList,
           java.lang.String SMSDataText) {
           this.SMSEDataTOList = SMSEDataTOList;
           this.SMSDataText = SMSDataText;
    }


    /**
     * Gets the SMSEDataTOList value for this SMSSenderRequestType.
     * 
     * @return SMSEDataTOList
     */
    public java.lang.String getSMSEDataTOList() {
        return SMSEDataTOList;
    }


    /**
     * Sets the SMSEDataTOList value for this SMSSenderRequestType.
     * 
     * @param SMSEDataTOList
     */
    public void setSMSEDataTOList(java.lang.String SMSEDataTOList) {
        this.SMSEDataTOList = SMSEDataTOList;
    }


    /**
     * Gets the SMSDataText value for this SMSSenderRequestType.
     * 
     * @return SMSDataText
     */
    public java.lang.String getSMSDataText() {
        return SMSDataText;
    }


    /**
     * Sets the SMSDataText value for this SMSSenderRequestType.
     * 
     * @param SMSDataText
     */
    public void setSMSDataText(java.lang.String SMSDataText) {
        this.SMSDataText = SMSDataText;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SMSSenderRequestType)) return false;
        SMSSenderRequestType other = (SMSSenderRequestType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.SMSEDataTOList==null && other.getSMSEDataTOList()==null) || 
             (this.SMSEDataTOList!=null &&
              this.SMSEDataTOList.equals(other.getSMSEDataTOList()))) &&
            ((this.SMSDataText==null && other.getSMSDataText()==null) || 
             (this.SMSDataText!=null &&
              this.SMSDataText.equals(other.getSMSDataText())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getSMSEDataTOList() != null) {
            _hashCode += getSMSEDataTOList().hashCode();
        }
        if (getSMSDataText() != null) {
            _hashCode += getSMSDataText().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SMSSenderRequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dati.webservices.smssender.seda.com", "SMSSenderRequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SMSEDataTOList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.webservices.smssender.seda.com", "SMSEDataTOList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SMSDataText");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dati.webservices.smssender.seda.com", "SMSDataText"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
