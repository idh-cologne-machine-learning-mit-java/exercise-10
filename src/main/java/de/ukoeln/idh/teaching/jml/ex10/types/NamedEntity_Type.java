
/* First created by JCasGen Fri Jan 22 15:42:19 CET 2021 */
package de.ukoeln.idh.teaching.jml.ex10.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Fri Jan 22 15:42:19 CET 2021
 * @generated */
public class NamedEntity_Type extends Annotation_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = NamedEntity.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity");
 
  /** @generated */
  final Feature casFeat_Confidence;
  /** @generated */
  final int     casFeatCode_Confidence;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public double getConfidence(int addr) {
        if (featOkTst && casFeat_Confidence == null)
      jcas.throwFeatMissing("Confidence", "de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_Confidence);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setConfidence(int addr, double v) {
        if (featOkTst && casFeat_Confidence == null)
      jcas.throwFeatMissing("Confidence", "de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_Confidence, v);}
    
  
 
  /** @generated */
  final Feature casFeat_NEClass;
  /** @generated */
  final int     casFeatCode_NEClass;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getNEClass(int addr) {
        if (featOkTst && casFeat_NEClass == null)
      jcas.throwFeatMissing("NEClass", "de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity");
    return ll_cas.ll_getStringValue(addr, casFeatCode_NEClass);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setNEClass(int addr, String v) {
        if (featOkTst && casFeat_NEClass == null)
      jcas.throwFeatMissing("NEClass", "de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity");
    ll_cas.ll_setStringValue(addr, casFeatCode_NEClass, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Source;
  /** @generated */
  final int     casFeatCode_Source;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getSource(int addr) {
        if (featOkTst && casFeat_Source == null)
      jcas.throwFeatMissing("Source", "de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Source);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setSource(int addr, String v) {
        if (featOkTst && casFeat_Source == null)
      jcas.throwFeatMissing("Source", "de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity");
    ll_cas.ll_setStringValue(addr, casFeatCode_Source, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public NamedEntity_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_Confidence = jcas.getRequiredFeatureDE(casType, "Confidence", "uima.cas.Double", featOkTst);
    casFeatCode_Confidence  = (null == casFeat_Confidence) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Confidence).getCode();

 
    casFeat_NEClass = jcas.getRequiredFeatureDE(casType, "NEClass", "uima.cas.String", featOkTst);
    casFeatCode_NEClass  = (null == casFeat_NEClass) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_NEClass).getCode();

 
    casFeat_Source = jcas.getRequiredFeatureDE(casType, "Source", "uima.cas.String", featOkTst);
    casFeatCode_Source  = (null == casFeat_Source) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Source).getCode();

  }
}



    