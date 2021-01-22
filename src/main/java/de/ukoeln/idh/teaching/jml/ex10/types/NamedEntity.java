

/* First created by JCasGen Fri Jan 22 15:42:19 CET 2021 */
package de.ukoeln.idh.teaching.jml.ex10.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Fri Jan 22 15:42:19 CET 2021
 * XML source: /Users/thomas/Desktop/Uni/Master/WiSe20_21/Machine Learning/exercise-10/src/main/resources/types.xml
 * @generated */
public class NamedEntity extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(NamedEntity.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected NamedEntity() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public NamedEntity(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public NamedEntity(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public NamedEntity(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: Confidence

  /** getter for Confidence - gets 
   * @generated
   * @return value of the feature 
   */
  public double getConfidence() {
    if (NamedEntity_Type.featOkTst && ((NamedEntity_Type)jcasType).casFeat_Confidence == null)
      jcasType.jcas.throwFeatMissing("Confidence", "de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_Confidence);}
    
  /** setter for Confidence - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setConfidence(double v) {
    if (NamedEntity_Type.featOkTst && ((NamedEntity_Type)jcasType).casFeat_Confidence == null)
      jcasType.jcas.throwFeatMissing("Confidence", "de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_Confidence, v);}    
   
    
  //*--------------*
  //* Feature: NEClass

  /** getter for NEClass - gets 
   * @generated
   * @return value of the feature 
   */
  public String getNEClass() {
    if (NamedEntity_Type.featOkTst && ((NamedEntity_Type)jcasType).casFeat_NEClass == null)
      jcasType.jcas.throwFeatMissing("NEClass", "de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity");
    return jcasType.ll_cas.ll_getStringValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_NEClass);}
    
  /** setter for NEClass - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setNEClass(String v) {
    if (NamedEntity_Type.featOkTst && ((NamedEntity_Type)jcasType).casFeat_NEClass == null)
      jcasType.jcas.throwFeatMissing("NEClass", "de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity");
    jcasType.ll_cas.ll_setStringValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_NEClass, v);}    
   
    
  //*--------------*
  //* Feature: Source

  /** getter for Source - gets 
   * @generated
   * @return value of the feature 
   */
  public String getSource() {
    if (NamedEntity_Type.featOkTst && ((NamedEntity_Type)jcasType).casFeat_Source == null)
      jcasType.jcas.throwFeatMissing("Source", "de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity");
    return jcasType.ll_cas.ll_getStringValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_Source);}
    
  /** setter for Source - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setSource(String v) {
    if (NamedEntity_Type.featOkTst && ((NamedEntity_Type)jcasType).casFeat_Source == null)
      jcasType.jcas.throwFeatMissing("Source", "de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity");
    jcasType.ll_cas.ll_setStringValue(addr, ((NamedEntity_Type)jcasType).casFeatCode_Source, v);}    
  }

    