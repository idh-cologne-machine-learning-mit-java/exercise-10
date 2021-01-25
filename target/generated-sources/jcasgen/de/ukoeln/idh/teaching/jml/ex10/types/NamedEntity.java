

   
/* Apache UIMA v3 - First created by JCasGen Mon Jan 25 18:32:39 CET 2021 */

package de.ukoeln.idh.teaching.jml.ex10.types;
 

import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandle;

import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.impl.TypeSystemImpl;
import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;


import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Mon Jan 25 18:32:39 CET 2021
 * XML source: C:/Users/morit/GitHub/exercise-10/target/jcasgen/typesystem.xml
 * @generated */
public class NamedEntity extends Annotation {
 
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static String _TypeName = "de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity";
  
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
 
 
  /* *******************
   *   Feature Offsets *
   * *******************/ 
   
  public final static String _FeatName_Confidence = "Confidence";
  public final static String _FeatName_NEClass = "NEClass";
  public final static String _FeatName_Source = "Source";


  /* Feature Adjusted Offsets */
  private final static CallSite _FC_Confidence = TypeSystemImpl.createCallSite(NamedEntity.class, "Confidence");
  private final static MethodHandle _FH_Confidence = _FC_Confidence.dynamicInvoker();
  private final static CallSite _FC_NEClass = TypeSystemImpl.createCallSite(NamedEntity.class, "NEClass");
  private final static MethodHandle _FH_NEClass = _FC_NEClass.dynamicInvoker();
  private final static CallSite _FC_Source = TypeSystemImpl.createCallSite(NamedEntity.class, "Source");
  private final static MethodHandle _FH_Source = _FC_Source.dynamicInvoker();

   
  /** Never called.  Disable default constructor
   * @generated */
  @Deprecated
  @SuppressWarnings ("deprecation")
  protected NamedEntity() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param casImpl the CAS this Feature Structure belongs to
   * @param type the type of this Feature Structure 
   */
  public NamedEntity(TypeImpl type, CASImpl casImpl) {
    super(type, casImpl);
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
    return _getDoubleValueNc(wrapGetIntCatchException(_FH_Confidence));
  }
    
  /** setter for Confidence - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setConfidence(double v) {
    _setDoubleValueNfc(wrapGetIntCatchException(_FH_Confidence), v);
  }    
    
   
    
  //*--------------*
  //* Feature: NEClass

  /** getter for NEClass - gets 
   * @generated
   * @return value of the feature 
   */
  public String getNEClass() { 
    return _getStringValueNc(wrapGetIntCatchException(_FH_NEClass));
  }
    
  /** setter for NEClass - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setNEClass(String v) {
    _setStringValueNfc(wrapGetIntCatchException(_FH_NEClass), v);
  }    
    
   
    
  //*--------------*
  //* Feature: Source

  /** getter for Source - gets 
   * @generated
   * @return value of the feature 
   */
  public String getSource() { 
    return _getStringValueNc(wrapGetIntCatchException(_FH_Source));
  }
    
  /** setter for Source - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setSource(String v) {
    _setStringValueNfc(wrapGetIntCatchException(_FH_Source), v);
  }    
    
  }

    