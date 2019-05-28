package com.ensicaen.dromard.Backend;

import java.sql.Time;


public class Assertion {

    //!-- Attribute of assertion
    private String idAssertion;
    private String versionAssertion;
    private Time issueInstant;
    private String attributeProvider;
    private String signatureOfIssuer;
    private Time startValidityInstant;
    private Time endValidityInstant;
    private String Value;
    private String blockchainAddressOfSubject;

    //!-- Creation of a SAML file
    public String generateSAML() throws Exception
    {
        return "";
    }



    public Assertion(String idAssertion, String versionAssertion, String attributeProvider, String value, String blockchainAddressOfSubject) {
        this.idAssertion = idAssertion;
        this.versionAssertion = versionAssertion;
        this.attributeProvider = attributeProvider;
        Value = value;
        this.blockchainAddressOfSubject = blockchainAddressOfSubject;
    }

    public String getIdAssertion() {
        return idAssertion;
    }

    public void setIdAssertion(String idAssertion) {
        this.idAssertion = idAssertion;
    }

    public String getVersionAssertion() {
        return versionAssertion;
    }

    public void setVersionAssertion(String versionAssertion) {
        this.versionAssertion = versionAssertion;
    }

    public Time getIssueInstant() {
        return issueInstant;
    }

    public void setIssueInstant(Time issueInstant) {
        this.issueInstant = issueInstant;
    }

    public String getAttributeProvider() {
        return attributeProvider;
    }

    public void setAttributeProvider(String attributeProvider) {
        this.attributeProvider = attributeProvider;
    }

    public String getSignatureOfIssuer() {
        return signatureOfIssuer;
    }

    public void setSignatureOfIssuer(String signatureOfIssuer) {
        this.signatureOfIssuer = signatureOfIssuer;
    }

    public Time getStartValidityInstant() {
        return startValidityInstant;
    }

    public void setStartValidityInstant(Time startValidityInstant) {
        this.startValidityInstant = startValidityInstant;
    }

    public Time getEndValidityInstant() {
        return endValidityInstant;
    }

    public void setEndValidityInstant(Time endValidityInstant) {
        this.endValidityInstant = endValidityInstant;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getBlockchainAddressOfSubject() {
        return blockchainAddressOfSubject;
    }

    public void setBlockchainAddressOfSubject(String blockchainAddressOfSubject) {
        this.blockchainAddressOfSubject = blockchainAddressOfSubject;
    }
}
