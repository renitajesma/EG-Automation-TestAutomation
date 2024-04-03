package folderAPI;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {
		public String IFC_LTF_Own_Account_Vol;
	
	public Integer FiscalYr;
	  
	    public String SummaryDate;
	   
	    public String RegionDeptCode;
	   
	    public String SuperRegion;
	   
	    public Double IFCLTFOwnAccountVol;
	   
	    public Double IFCLTFOwnAccountVolMax;
	  
	    public Double IFCLTFOwnAccountTgt;
	    
	    public Double IFCLTFOwnAccountTgtBuffer;
	   
	    public Double IFCLTFOwnAccountTgtBufferMax;
	   
	    public Double IFCLTFOwnAccountPct;
	   
	    public Double TotalLTFVolInclMIGA;
	    
	    public Double TotalLTFVolExclMIGA;
	   
	    public Double TotalLTFVolInclMIGAMax;
	   
	    public Double TotalLTFVolExclMIGAMax;
	  
	    public Double TotalLTFTgt;
	   
	    public Double TotalLTFTgtBufferMax;
	  
	    public Double TotalLTFInclMIGAPct;
	   
	    public Double TotalLTFExclMIGAPct;
	   
	    public Double TotalLTFTgtBuffer;
	   
	    public Double IDA17FCSLTFOAVol;
	  
	    public Double IDA17FCSLTFOATgt;
	   
	    public Double IDA17FCSLTFOATgtBuffer;
	   
	    public Double IDA17FCSLTFOATgtBufferMax;
	   
	    public Double IDA17FCSLTFOAPct;
	  
	    public Double IDA17FCSLTFOAPctMax;
	   
	    public Double FCSLICIDA17LTFOAVol;
	   
	    public Double FCSLICIDA17LTFOATgt;
	   
	    public Double FCSLICIDA17LTFOATgtBuffer;
	  
	    public Double FCSLICIDA17LTFOATgtBufferMax;
	  
	    public Double FCSLICIDA17LTFOAPct;
	   
	    public Double FCSLICIDA17LTFOAPctMax;
	  
	    public Double LTFIDA17ProjectCnt;
	    
	    public Double LTFIDA17ProjectTgt;
	   
	    public Double LTFIDA17ProjectTgtBuffer;
	   
	    public Double LTFIDA17ProjectTgtBufferMax;
	  
	    public Double IDA17LTFOATgt;
	   
	    public Double IDA17LTFOATgtBuffer;
	   
	    public Double IDA17LTFOATgtBufferMax;
	   
	    public Double IDA17LTFOACnt;
	    
	    public Double LTFIDA17ProjectPct;
	   
	    public Double LTFIDA17ProjectPctMax;
	   
	    public Double ClimateLTFOAVol;
	   
	    public Double ClimateLTFOATgt;
	   
	    public Double ClimateLTFOATgtBuffer;
	    
	    public Double ClimateLTFOATgtBufferMax;
	  
	    public Double ClimateLTFOAPct;
	   
	    public Double ClimateLTFOAPctMax;
	    
	    public Double IDA17LTFOAVol;
	   
	    public Double IDA17LTFOAPct;
	   
	    public Double IDA17LTFOAPctMax;
	  
	    public Double BunchingActual;
	   
	    public Double BunchingQ2Pct;
	   
	    public Double BunchingQ3Pct;
	   
	    public Double BunchingQ2Tgt;
	   
	    public Double BunchingQ3Tgt;
	   
	    public Double IFCSTFOwnAccountVol;
	   
	    public Double IFCSTFOwnAccountVolMax;
	  
	    public Double IFCSTFOwnAccountTgt;
	   
	    public Double IFCSTFOwnAccountTgtBuffer;
	   
	    public Double IFCSTFOwnAccountTgtBufferMax;
	    
	    public Double IFCSTFOwnAccountPct;
	   
	    public Double IDA17FCSSTFOAVol;
	   
	    public Double IDA17FCSSTFOATgt;

	    public Double IDA17FCSSTFOATgtBuffer;
	   
	    public Double IDA17FCSSTFOATgtBufferMax;
	  
	    public Double IDA17FCSSTFOAPct;
	    
	    public Double IDA17FCSSTFOAPctMax;
	    
	    public Double FCSLICIDA17STFOAVol;
	    
	    public Double FCSLICIDA17STFOATgt;
	    
	    public Double FCSLICIDA17STFOATgtBufferMax;
	    
	    public Double FCSLICIDA17STFOATgtBuffer;
	    
	    public Double FCSLICIDA17STFOAPct;
	    
	    public Double FCSLICIDA17STFOAPctMax;
	    
	    public Double MIGAMobilizationVol;
	    
	    public Double MIGAMobilizationVolMax;
	    
	    public Double MIGAMobilizationTgt;
	    
	    public Double MIGAMobilizationTgtBuffer;
	    
	    public Double MIGAMobilizationTgtBufferMax;
	   
	    public Double MIGAMobilizationPct;
	   
	    public Double MIGAMobilizationPctMax;
	   
	    public Double Cumulative1yrInvOAVol;
	   
	    public Double Cumulative1yrInvOAVolFY;
	   
	    public Double Cumulative1yrInvOAVolFYPlus1;
	   
	    public Double Cumulative1yrInvOAVolMax;
	   
	    public Double Cumulative1yrInvOATgt;
	   
	    public Double Cumulative1yrInvOATgtBuffer;
	   
	    public Double Cumulative1yrInvOAPct;
	   
	    public Double Cumulative1yrInvOAPctMax;
	   
	    public Double Cumulative1yrInvOAProjectCntFY;
	   
	    public Double Cumulative1yrInvOAProjectCntFYPlus1;
	   
	    public Double Cumulative1yrInvOAProjectCntMax;
	   
	    public Double AIMMScoreAvg;
	   
	    public Double MarketCreationPct;
	   
	    public Double AIMMScoreTgt;
	   
	    public Double MarketCreationTgt;
	   
	    public Double FisWomenNewLTFOACoreMobVol;
	   
	    public Double FisWomenNewLTFOACoreMobVolMax;
	   
	    public Double FisWomenNewLTFOACoreMobPct;
	   
	    public Double FisWomenNewLTFOACoreMobTgt;   
	    public Double FisWomenNewLTFOACoreMobTgtBuffer;   
	    public Double FisWomenNewLTFOACoreMobTgtBufferMax;
	    public String Name;
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public Integer getFiscalYr() {
			return FiscalYr;
		}
		public void setFiscalYr(Integer fiscalYr) {
			FiscalYr = fiscalYr;
		}
		public String getSummaryDate() {
			return SummaryDate;
		}
		public void setSummaryDate(String summaryDate) {
			SummaryDate = summaryDate;
		}
		public String getRegionDeptCode() {
			return RegionDeptCode;
		}
		public void setRegionDeptCode(String regionDeptCode) {
			RegionDeptCode = regionDeptCode;
		}
		public String getSuperRegion() {
			return SuperRegion;
		}
		public void setSuperRegion(String superRegion) {
			SuperRegion = superRegion;
		}
		public Double getIFCLTFOwnAccountVol() {
			return IFCLTFOwnAccountVol;
		}
		public void setIFCLTFOwnAccountVol(Double iFCLTFOwnAccountVol) {
			IFCLTFOwnAccountVol = iFCLTFOwnAccountVol;
		}
		public Double getIFCLTFOwnAccountVolMax() {
			return IFCLTFOwnAccountVolMax;
		}
		public void setIFCLTFOwnAccountVolMax(Double iFCLTFOwnAccountVolMax) {
			IFCLTFOwnAccountVolMax = iFCLTFOwnAccountVolMax;
		}
		public Double getIFCLTFOwnAccountTgt() {
			return IFCLTFOwnAccountTgt;
		}
		public void setIFCLTFOwnAccountTgt(Double iFCLTFOwnAccountTgt) {
			IFCLTFOwnAccountTgt = iFCLTFOwnAccountTgt;
		}
		public Double getIFCLTFOwnAccountTgtBuffer() {
			return IFCLTFOwnAccountTgtBuffer;
		}
		public void setIFCLTFOwnAccountTgtBuffer(Double iFCLTFOwnAccountTgtBuffer) {
			IFCLTFOwnAccountTgtBuffer = iFCLTFOwnAccountTgtBuffer;
		}
		public Double getIFCLTFOwnAccountTgtBufferMax() {
			return IFCLTFOwnAccountTgtBufferMax;
		}
		public void setIFCLTFOwnAccountTgtBufferMax(Double iFCLTFOwnAccountTgtBufferMax) {
			IFCLTFOwnAccountTgtBufferMax = iFCLTFOwnAccountTgtBufferMax;
		}
		public Double getIFCLTFOwnAccountPct() {
			return IFCLTFOwnAccountPct;
		}
		public void setIFCLTFOwnAccountPct(Double iFCLTFOwnAccountPct) {
			IFCLTFOwnAccountPct = iFCLTFOwnAccountPct;
		}
		public Double getTotalLTFVolInclMIGA() {
			return TotalLTFVolInclMIGA;
		}
		public void setTotalLTFVolInclMIGA(Double totalLTFVolInclMIGA) {
			TotalLTFVolInclMIGA = totalLTFVolInclMIGA;
		}
		public Double getTotalLTFVolExclMIGA() {
			return TotalLTFVolExclMIGA;
		}
		public void setTotalLTFVolExclMIGA(Double totalLTFVolExclMIGA) {
			TotalLTFVolExclMIGA = totalLTFVolExclMIGA;
		}
		public Double getTotalLTFVolInclMIGAMax() {
			return TotalLTFVolInclMIGAMax;
		}
		public void setTotalLTFVolInclMIGAMax(Double totalLTFVolInclMIGAMax) {
			TotalLTFVolInclMIGAMax = totalLTFVolInclMIGAMax;
		}
		public Double getTotalLTFVolExclMIGAMax() {
			return TotalLTFVolExclMIGAMax;
		}
		public void setTotalLTFVolExclMIGAMax(Double totalLTFVolExclMIGAMax) {
			TotalLTFVolExclMIGAMax = totalLTFVolExclMIGAMax;
		}
		public Double getTotalLTFTgt() {
			return TotalLTFTgt;
		}
		public void setTotalLTFTgt(Double totalLTFTgt) {
			TotalLTFTgt = totalLTFTgt;
		}
		public Double getTotalLTFTgtBufferMax() {
			return TotalLTFTgtBufferMax;
		}
		public void setTotalLTFTgtBufferMax(Double totalLTFTgtBufferMax) {
			TotalLTFTgtBufferMax = totalLTFTgtBufferMax;
		}
		public Double getTotalLTFInclMIGAPct() {
			return TotalLTFInclMIGAPct;
		}
		public void setTotalLTFInclMIGAPct(Double totalLTFInclMIGAPct) {
			TotalLTFInclMIGAPct = totalLTFInclMIGAPct;
		}
		public Double getTotalLTFExclMIGAPct() {
			return TotalLTFExclMIGAPct;
		}
		public void setTotalLTFExclMIGAPct(Double totalLTFExclMIGAPct) {
			TotalLTFExclMIGAPct = totalLTFExclMIGAPct;
		}
		public Double getTotalLTFTgtBuffer() {
			return TotalLTFTgtBuffer;
		}
		public void setTotalLTFTgtBuffer(Double totalLTFTgtBuffer) {
			TotalLTFTgtBuffer = totalLTFTgtBuffer;
		}
		public Double getIDA17FCSLTFOAVol() {
			return IDA17FCSLTFOAVol;
		}
		public void setIDA17FCSLTFOAVol(Double iDA17FCSLTFOAVol) {
			IDA17FCSLTFOAVol = iDA17FCSLTFOAVol;
		}
		public Double getIDA17FCSLTFOATgt() {
			return IDA17FCSLTFOATgt;
		}
		public void setIDA17FCSLTFOATgt(Double iDA17FCSLTFOATgt) {
			IDA17FCSLTFOATgt = iDA17FCSLTFOATgt;
		}
		public Double getIDA17FCSLTFOATgtBuffer() {
			return IDA17FCSLTFOATgtBuffer;
		}
		public void setIDA17FCSLTFOATgtBuffer(Double iDA17FCSLTFOATgtBuffer) {
			IDA17FCSLTFOATgtBuffer = iDA17FCSLTFOATgtBuffer;
		}
		public Double getIDA17FCSLTFOATgtBufferMax() {
			return IDA17FCSLTFOATgtBufferMax;
		}
		public void setIDA17FCSLTFOATgtBufferMax(Double iDA17FCSLTFOATgtBufferMax) {
			IDA17FCSLTFOATgtBufferMax = iDA17FCSLTFOATgtBufferMax;
		}
		public Double getIDA17FCSLTFOAPct() {
			return IDA17FCSLTFOAPct;
		}
		public void setIDA17FCSLTFOAPct(Double iDA17FCSLTFOAPct) {
			IDA17FCSLTFOAPct = iDA17FCSLTFOAPct;
		}
		public Double getIDA17FCSLTFOAPctMax() {
			return IDA17FCSLTFOAPctMax;
		}
		public void setIDA17FCSLTFOAPctMax(Double iDA17FCSLTFOAPctMax) {
			IDA17FCSLTFOAPctMax = iDA17FCSLTFOAPctMax;
		}
		public Double getFCSLICIDA17LTFOAVol() {
			return FCSLICIDA17LTFOAVol;
		}
		public void setFCSLICIDA17LTFOAVol(Double fCSLICIDA17LTFOAVol) {
			FCSLICIDA17LTFOAVol = fCSLICIDA17LTFOAVol;
		}
		public Double getFCSLICIDA17LTFOATgt() {
			return FCSLICIDA17LTFOATgt;
		}
		public void setFCSLICIDA17LTFOATgt(Double fCSLICIDA17LTFOATgt) {
			FCSLICIDA17LTFOATgt = fCSLICIDA17LTFOATgt;
		}
		public Double getFCSLICIDA17LTFOATgtBuffer() {
			return FCSLICIDA17LTFOATgtBuffer;
		}
		public void setFCSLICIDA17LTFOATgtBuffer(Double fCSLICIDA17LTFOATgtBuffer) {
			FCSLICIDA17LTFOATgtBuffer = fCSLICIDA17LTFOATgtBuffer;
		}
		public Double getFCSLICIDA17LTFOATgtBufferMax() {
			return FCSLICIDA17LTFOATgtBufferMax;
		}
		public void setFCSLICIDA17LTFOATgtBufferMax(Double fCSLICIDA17LTFOATgtBufferMax) {
			FCSLICIDA17LTFOATgtBufferMax = fCSLICIDA17LTFOATgtBufferMax;
		}
		public Double getFCSLICIDA17LTFOAPct() {
			return FCSLICIDA17LTFOAPct;
		}
		public void setFCSLICIDA17LTFOAPct(Double fCSLICIDA17LTFOAPct) {
			FCSLICIDA17LTFOAPct = fCSLICIDA17LTFOAPct;
		}
		public Double getFCSLICIDA17LTFOAPctMax() {
			return FCSLICIDA17LTFOAPctMax;
		}
		public void setFCSLICIDA17LTFOAPctMax(Double fCSLICIDA17LTFOAPctMax) {
			FCSLICIDA17LTFOAPctMax = fCSLICIDA17LTFOAPctMax;
		}
		public Double getLTFIDA17ProjectCnt() {
			return LTFIDA17ProjectCnt;
		}
		public void setLTFIDA17ProjectCnt(Double lTFIDA17ProjectCnt) {
			LTFIDA17ProjectCnt = lTFIDA17ProjectCnt;
		}
		public Double getLTFIDA17ProjectTgt() {
			return LTFIDA17ProjectTgt;
		}
		public void setLTFIDA17ProjectTgt(Double lTFIDA17ProjectTgt) {
			LTFIDA17ProjectTgt = lTFIDA17ProjectTgt;
		}
		public Double getLTFIDA17ProjectTgtBuffer() {
			return LTFIDA17ProjectTgtBuffer;
		}
		public void setLTFIDA17ProjectTgtBuffer(Double lTFIDA17ProjectTgtBuffer) {
			LTFIDA17ProjectTgtBuffer = lTFIDA17ProjectTgtBuffer;
		}
		public Double getLTFIDA17ProjectTgtBufferMax() {
			return LTFIDA17ProjectTgtBufferMax;
		}
		public void setLTFIDA17ProjectTgtBufferMax(Double lTFIDA17ProjectTgtBufferMax) {
			LTFIDA17ProjectTgtBufferMax = lTFIDA17ProjectTgtBufferMax;
		}
		public Double getIDA17LTFOATgt() {
			return IDA17LTFOATgt;
		}
		public void setIDA17LTFOATgt(Double iDA17LTFOATgt) {
			IDA17LTFOATgt = iDA17LTFOATgt;
		}
		public Double getIDA17LTFOATgtBuffer() {
			return IDA17LTFOATgtBuffer;
		}
		public void setIDA17LTFOATgtBuffer(Double iDA17LTFOATgtBuffer) {
			IDA17LTFOATgtBuffer = iDA17LTFOATgtBuffer;
		}
		public Double getIDA17LTFOATgtBufferMax() {
			return IDA17LTFOATgtBufferMax;
		}
		public void setIDA17LTFOATgtBufferMax(Double iDA17LTFOATgtBufferMax) {
			IDA17LTFOATgtBufferMax = iDA17LTFOATgtBufferMax;
		}
		public Double getIDA17LTFOACnt() {
			return IDA17LTFOACnt;
		}
		public void setIDA17LTFOACnt(Double iDA17LTFOACnt) {
			IDA17LTFOACnt = iDA17LTFOACnt;
		}
		public Double getLTFIDA17ProjectPct() {
			return LTFIDA17ProjectPct;
		}
		public void setLTFIDA17ProjectPct(Double lTFIDA17ProjectPct) {
			LTFIDA17ProjectPct = lTFIDA17ProjectPct;
		}
		public Double getLTFIDA17ProjectPctMax() {
			return LTFIDA17ProjectPctMax;
		}
		public void setLTFIDA17ProjectPctMax(Double lTFIDA17ProjectPctMax) {
			LTFIDA17ProjectPctMax = lTFIDA17ProjectPctMax;
		}
		public Double getClimateLTFOAVol() {
			return ClimateLTFOAVol;
		}
		public void setClimateLTFOAVol(Double climateLTFOAVol) {
			ClimateLTFOAVol = climateLTFOAVol;
		}
		public Double getClimateLTFOATgt() {
			return ClimateLTFOATgt;
		}
		public void setClimateLTFOATgt(Double climateLTFOATgt) {
			ClimateLTFOATgt = climateLTFOATgt;
		}
		public Double getClimateLTFOATgtBuffer() {
			return ClimateLTFOATgtBuffer;
		}
		public void setClimateLTFOATgtBuffer(Double climateLTFOATgtBuffer) {
			ClimateLTFOATgtBuffer = climateLTFOATgtBuffer;
		}
		public Double getClimateLTFOATgtBufferMax() {
			return ClimateLTFOATgtBufferMax;
		}
		public void setClimateLTFOATgtBufferMax(Double climateLTFOATgtBufferMax) {
			ClimateLTFOATgtBufferMax = climateLTFOATgtBufferMax;
		}
		public Double getClimateLTFOAPct() {
			return ClimateLTFOAPct;
		}
		public void setClimateLTFOAPct(Double climateLTFOAPct) {
			ClimateLTFOAPct = climateLTFOAPct;
		}
		public Double getClimateLTFOAPctMax() {
			return ClimateLTFOAPctMax;
		}
		public void setClimateLTFOAPctMax(Double climateLTFOAPctMax) {
			ClimateLTFOAPctMax = climateLTFOAPctMax;
		}
		public Double getIDA17LTFOAVol() {
			return IDA17LTFOAVol;
		}
		public void setIDA17LTFOAVol(Double iDA17LTFOAVol) {
			IDA17LTFOAVol = iDA17LTFOAVol;
		}
		public Double getIDA17LTFOAPct() {
			return IDA17LTFOAPct;
		}
		public void setIDA17LTFOAPct(Double iDA17LTFOAPct) {
			IDA17LTFOAPct = iDA17LTFOAPct;
		}
		public Double getIDA17LTFOAPctMax() {
			return IDA17LTFOAPctMax;
		}
		public void setIDA17LTFOAPctMax(Double iDA17LTFOAPctMax) {
			IDA17LTFOAPctMax = iDA17LTFOAPctMax;
		}
		public Double getBunchingActual() {
			return BunchingActual;
		}
		public void setBunchingActual(Double bunchingActual) {
			BunchingActual = bunchingActual;
		}
		public Double getBunchingQ2Pct() {
			return BunchingQ2Pct;
		}
		public void setBunchingQ2Pct(Double bunchingQ2Pct) {
			BunchingQ2Pct = bunchingQ2Pct;
		}
		public Double getBunchingQ3Pct() {
			return BunchingQ3Pct;
		}
		public void setBunchingQ3Pct(Double bunchingQ3Pct) {
			BunchingQ3Pct = bunchingQ3Pct;
		}
		public Double getBunchingQ2Tgt() {
			return BunchingQ2Tgt;
		}
		public void setBunchingQ2Tgt(Double bunchingQ2Tgt) {
			BunchingQ2Tgt = bunchingQ2Tgt;
		}
		public Double getBunchingQ3Tgt() {
			return BunchingQ3Tgt;
		}
		public void setBunchingQ3Tgt(Double bunchingQ3Tgt) {
			BunchingQ3Tgt = bunchingQ3Tgt;
		}
		public Double getIFCSTFOwnAccountVol() {
			return IFCSTFOwnAccountVol;
		}
		public void setIFCSTFOwnAccountVol(Double iFCSTFOwnAccountVol) {
			IFCSTFOwnAccountVol = iFCSTFOwnAccountVol;
		}
		public Double getIFCSTFOwnAccountVolMax() {
			return IFCSTFOwnAccountVolMax;
		}
		public void setIFCSTFOwnAccountVolMax(Double iFCSTFOwnAccountVolMax) {
			IFCSTFOwnAccountVolMax = iFCSTFOwnAccountVolMax;
		}
		public Double getIFCSTFOwnAccountTgt() {
			return IFCSTFOwnAccountTgt;
		}
		public void setIFCSTFOwnAccountTgt(Double iFCSTFOwnAccountTgt) {
			IFCSTFOwnAccountTgt = iFCSTFOwnAccountTgt;
		}
		public Double getIFCSTFOwnAccountTgtBuffer() {
			return IFCSTFOwnAccountTgtBuffer;
		}
		public void setIFCSTFOwnAccountTgtBuffer(Double iFCSTFOwnAccountTgtBuffer) {
			IFCSTFOwnAccountTgtBuffer = iFCSTFOwnAccountTgtBuffer;
		}
		public Double getIFCSTFOwnAccountTgtBufferMax() {
			return IFCSTFOwnAccountTgtBufferMax;
		}
		public void setIFCSTFOwnAccountTgtBufferMax(Double iFCSTFOwnAccountTgtBufferMax) {
			IFCSTFOwnAccountTgtBufferMax = iFCSTFOwnAccountTgtBufferMax;
		}
		public Double getIFCSTFOwnAccountPct() {
			return IFCSTFOwnAccountPct;
		}
		public void setIFCSTFOwnAccountPct(Double iFCSTFOwnAccountPct) {
			IFCSTFOwnAccountPct = iFCSTFOwnAccountPct;
		}
		public Double getIDA17FCSSTFOAVol() {
			return IDA17FCSSTFOAVol;
		}
		public void setIDA17FCSSTFOAVol(Double iDA17FCSSTFOAVol) {
			IDA17FCSSTFOAVol = iDA17FCSSTFOAVol;
		}
		public Double getIDA17FCSSTFOATgt() {
			return IDA17FCSSTFOATgt;
		}
		public void setIDA17FCSSTFOATgt(Double iDA17FCSSTFOATgt) {
			IDA17FCSSTFOATgt = iDA17FCSSTFOATgt;
		}
		public Double getIDA17FCSSTFOATgtBuffer() {
			return IDA17FCSSTFOATgtBuffer;
		}
		public void setIDA17FCSSTFOATgtBuffer(Double iDA17FCSSTFOATgtBuffer) {
			IDA17FCSSTFOATgtBuffer = iDA17FCSSTFOATgtBuffer;
		}
		public Double getIDA17FCSSTFOATgtBufferMax() {
			return IDA17FCSSTFOATgtBufferMax;
		}
		public void setIDA17FCSSTFOATgtBufferMax(Double iDA17FCSSTFOATgtBufferMax) {
			IDA17FCSSTFOATgtBufferMax = iDA17FCSSTFOATgtBufferMax;
		}
		public Double getIDA17FCSSTFOAPct() {
			return IDA17FCSSTFOAPct;
		}
		public void setIDA17FCSSTFOAPct(Double iDA17FCSSTFOAPct) {
			IDA17FCSSTFOAPct = iDA17FCSSTFOAPct;
		}
		public Double getIDA17FCSSTFOAPctMax() {
			return IDA17FCSSTFOAPctMax;
		}
		public void setIDA17FCSSTFOAPctMax(Double iDA17FCSSTFOAPctMax) {
			IDA17FCSSTFOAPctMax = iDA17FCSSTFOAPctMax;
		}
		public Double getFCSLICIDA17STFOAVol() {
			return FCSLICIDA17STFOAVol;
		}
		public void setFCSLICIDA17STFOAVol(Double fCSLICIDA17STFOAVol) {
			FCSLICIDA17STFOAVol = fCSLICIDA17STFOAVol;
		}
		public Double getFCSLICIDA17STFOATgt() {
			return FCSLICIDA17STFOATgt;
		}
		public void setFCSLICIDA17STFOATgt(Double fCSLICIDA17STFOATgt) {
			FCSLICIDA17STFOATgt = fCSLICIDA17STFOATgt;
		}
		public Double getFCSLICIDA17STFOATgtBufferMax() {
			return FCSLICIDA17STFOATgtBufferMax;
		}
		public void setFCSLICIDA17STFOATgtBufferMax(Double fCSLICIDA17STFOATgtBufferMax) {
			FCSLICIDA17STFOATgtBufferMax = fCSLICIDA17STFOATgtBufferMax;
		}
		public Double getFCSLICIDA17STFOATgtBuffer() {
			return FCSLICIDA17STFOATgtBuffer;
		}
		public void setFCSLICIDA17STFOATgtBuffer(Double fCSLICIDA17STFOATgtBuffer) {
			FCSLICIDA17STFOATgtBuffer = fCSLICIDA17STFOATgtBuffer;
		}
		public Double getFCSLICIDA17STFOAPct() {
			return FCSLICIDA17STFOAPct;
		}
		public void setFCSLICIDA17STFOAPct(Double fCSLICIDA17STFOAPct) {
			FCSLICIDA17STFOAPct = fCSLICIDA17STFOAPct;
		}
		public Double getFCSLICIDA17STFOAPctMax() {
			return FCSLICIDA17STFOAPctMax;
		}
		public void setFCSLICIDA17STFOAPctMax(Double fCSLICIDA17STFOAPctMax) {
			FCSLICIDA17STFOAPctMax = fCSLICIDA17STFOAPctMax;
		}
		public Double getMIGAMobilizationVol() {
			return MIGAMobilizationVol;
		}
		public void setMIGAMobilizationVol(Double mIGAMobilizationVol) {
			MIGAMobilizationVol = mIGAMobilizationVol;
		}
		public Double getMIGAMobilizationVolMax() {
			return MIGAMobilizationVolMax;
		}
		public void setMIGAMobilizationVolMax(Double mIGAMobilizationVolMax) {
			MIGAMobilizationVolMax = mIGAMobilizationVolMax;
		}
		public Double getMIGAMobilizationTgt() {
			return MIGAMobilizationTgt;
		}
		public void setMIGAMobilizationTgt(Double mIGAMobilizationTgt) {
			MIGAMobilizationTgt = mIGAMobilizationTgt;
		}
		public Double getMIGAMobilizationTgtBuffer() {
			return MIGAMobilizationTgtBuffer;
		}
		public void setMIGAMobilizationTgtBuffer(Double mIGAMobilizationTgtBuffer) {
			MIGAMobilizationTgtBuffer = mIGAMobilizationTgtBuffer;
		}
		public Double getMIGAMobilizationTgtBufferMax() {
			return MIGAMobilizationTgtBufferMax;
		}
		public void setMIGAMobilizationTgtBufferMax(Double mIGAMobilizationTgtBufferMax) {
			MIGAMobilizationTgtBufferMax = mIGAMobilizationTgtBufferMax;
		}
		public Double getMIGAMobilizationPct() {
			return MIGAMobilizationPct;
		}
		public void setMIGAMobilizationPct(Double mIGAMobilizationPct) {
			MIGAMobilizationPct = mIGAMobilizationPct;
		}
		public Double getMIGAMobilizationPctMax() {
			return MIGAMobilizationPctMax;
		}
		public void setMIGAMobilizationPctMax(Double mIGAMobilizationPctMax) {
			MIGAMobilizationPctMax = mIGAMobilizationPctMax;
		}
		public Double getCumulative1yrInvOAVol() {
			return Cumulative1yrInvOAVol;
		}
		public void setCumulative1yrInvOAVol(Double cumulative1yrInvOAVol) {
			Cumulative1yrInvOAVol = cumulative1yrInvOAVol;
		}
		public Double getCumulative1yrInvOAVolFY() {
			return Cumulative1yrInvOAVolFY;
		}
		public void setCumulative1yrInvOAVolFY(Double cumulative1yrInvOAVolFY) {
			Cumulative1yrInvOAVolFY = cumulative1yrInvOAVolFY;
		}
		public Double getCumulative1yrInvOAVolFYPlus1() {
			return Cumulative1yrInvOAVolFYPlus1;
		}
		public void setCumulative1yrInvOAVolFYPlus1(Double cumulative1yrInvOAVolFYPlus1) {
			Cumulative1yrInvOAVolFYPlus1 = cumulative1yrInvOAVolFYPlus1;
		}
		public Double getCumulative1yrInvOAVolMax() {
			return Cumulative1yrInvOAVolMax;
		}
		public void setCumulative1yrInvOAVolMax(Double cumulative1yrInvOAVolMax) {
			Cumulative1yrInvOAVolMax = cumulative1yrInvOAVolMax;
		}
		public Double getCumulative1yrInvOATgt() {
			return Cumulative1yrInvOATgt;
		}
		public void setCumulative1yrInvOATgt(Double cumulative1yrInvOATgt) {
			Cumulative1yrInvOATgt = cumulative1yrInvOATgt;
		}
		public Double getCumulative1yrInvOATgtBuffer() {
			return Cumulative1yrInvOATgtBuffer;
		}
		public void setCumulative1yrInvOATgtBuffer(Double cumulative1yrInvOATgtBuffer) {
			Cumulative1yrInvOATgtBuffer = cumulative1yrInvOATgtBuffer;
		}
		public Double getCumulative1yrInvOAPct() {
			return Cumulative1yrInvOAPct;
		}
		public void setCumulative1yrInvOAPct(Double cumulative1yrInvOAPct) {
			Cumulative1yrInvOAPct = cumulative1yrInvOAPct;
		}
		public Double getCumulative1yrInvOAPctMax() {
			return Cumulative1yrInvOAPctMax;
		}
		public void setCumulative1yrInvOAPctMax(Double cumulative1yrInvOAPctMax) {
			Cumulative1yrInvOAPctMax = cumulative1yrInvOAPctMax;
		}
		public Double getCumulative1yrInvOAProjectCntFY() {
			return Cumulative1yrInvOAProjectCntFY;
		}
		public void setCumulative1yrInvOAProjectCntFY(Double cumulative1yrInvOAProjectCntFY) {
			Cumulative1yrInvOAProjectCntFY = cumulative1yrInvOAProjectCntFY;
		}
		public Double getCumulative1yrInvOAProjectCntFYPlus1() {
			return Cumulative1yrInvOAProjectCntFYPlus1;
		}
		public void setCumulative1yrInvOAProjectCntFYPlus1(Double cumulative1yrInvOAProjectCntFYPlus1) {
			Cumulative1yrInvOAProjectCntFYPlus1 = cumulative1yrInvOAProjectCntFYPlus1;
		}
		public Double getCumulative1yrInvOAProjectCntMax() {
			return Cumulative1yrInvOAProjectCntMax;
		}
		public void setCumulative1yrInvOAProjectCntMax(Double cumulative1yrInvOAProjectCntMax) {
			Cumulative1yrInvOAProjectCntMax = cumulative1yrInvOAProjectCntMax;
		}
		public Double getAIMMScoreAvg() {
			return AIMMScoreAvg;
		}
		public void setAIMMScoreAvg(Double aIMMScoreAvg) {
			AIMMScoreAvg = aIMMScoreAvg;
		}
		public Double getMarketCreationPct() {
			return MarketCreationPct;
		}
		public void setMarketCreationPct(Double marketCreationPct) {
			MarketCreationPct = marketCreationPct;
		}
		public Double getAIMMScoreTgt() {
			return AIMMScoreTgt;
		}
		public void setAIMMScoreTgt(Double aIMMScoreTgt) {
			AIMMScoreTgt = aIMMScoreTgt;
		}
		public Double getMarketCreationTgt() {
			return MarketCreationTgt;
		}
		public void setMarketCreationTgt(Double marketCreationTgt) {
			MarketCreationTgt = marketCreationTgt;
		}
		public Double getFisWomenNewLTFOACoreMobVol() {
			return FisWomenNewLTFOACoreMobVol;
		}
		public void setFisWomenNewLTFOACoreMobVol(Double fisWomenNewLTFOACoreMobVol) {
			FisWomenNewLTFOACoreMobVol = fisWomenNewLTFOACoreMobVol;
		}
		public Double getFisWomenNewLTFOACoreMobVolMax() {
			return FisWomenNewLTFOACoreMobVolMax;
		}
		public void setFisWomenNewLTFOACoreMobVolMax(Double fisWomenNewLTFOACoreMobVolMax) {
			FisWomenNewLTFOACoreMobVolMax = fisWomenNewLTFOACoreMobVolMax;
		}
		public Double getFisWomenNewLTFOACoreMobPct() {
			return FisWomenNewLTFOACoreMobPct;
		}
		public void setFisWomenNewLTFOACoreMobPct(Double fisWomenNewLTFOACoreMobPct) {
			FisWomenNewLTFOACoreMobPct = fisWomenNewLTFOACoreMobPct;
		}
		public Double getFisWomenNewLTFOACoreMobTgt() {
			return FisWomenNewLTFOACoreMobTgt;
		}
		public void setFisWomenNewLTFOACoreMobTgt(Double fisWomenNewLTFOACoreMobTgt) {
			FisWomenNewLTFOACoreMobTgt = fisWomenNewLTFOACoreMobTgt;
		}
		public Double getFisWomenNewLTFOACoreMobTgtBuffer() {
			return FisWomenNewLTFOACoreMobTgtBuffer;
		}
		public void setFisWomenNewLTFOACoreMobTgtBuffer(Double fisWomenNewLTFOACoreMobTgtBuffer) {
			FisWomenNewLTFOACoreMobTgtBuffer = fisWomenNewLTFOACoreMobTgtBuffer;
		}
		public Double getFisWomenNewLTFOACoreMobTgtBufferMax() {
			return FisWomenNewLTFOACoreMobTgtBufferMax;
		}
		public void setFisWomenNewLTFOACoreMobTgtBufferMax(Double fisWomenNewLTFOACoreMobTgtBufferMax) {
			FisWomenNewLTFOACoreMobTgtBufferMax = fisWomenNewLTFOACoreMobTgtBufferMax;
		}
	   
		 public String getIFC_LTF_Own_Account_Vol() {
				return IFC_LTF_Own_Account_Vol;
			}
			public void setIFC_LTF_Own_Account_Vol(String iFC_LTF_Own_Account_Vol) {
				IFC_LTF_Own_Account_Vol = iFC_LTF_Own_Account_Vol;
			}
			
			public String getIFC_LTF_Own_Account_Vol_Max() {
				return IFC_LTF_Own_Account_Vol_Max;
			}
			public void setIFC_LTF_Own_Account_Vol_Max(String iFC_LTF_Own_Account_Vol_Max) {
				IFC_LTF_Own_Account_Vol_Max = iFC_LTF_Own_Account_Vol_Max;
			}

			public String IFC_LTF_Own_Account_Vol_Max;
}
