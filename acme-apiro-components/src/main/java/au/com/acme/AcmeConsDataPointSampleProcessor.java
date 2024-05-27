package au.com.acme;

import au.com.apirosolutions.rates.aggregate.postprocess.ConsDataPointProcessorIfc;
import au.com.apirosolutions.rates.enginecontext.PipelineEngineContextIfc;
import au.com.apirosolutions.rates.entity.AggregatedRate;
import au.com.apirosolutions.rates.entity.RateDefinition;
import au.com.apirosolutions.rates.entity.RateSchemaDefinition;
import au.com.apirosolutions.rates.entity.valuob.type.AggregatedRateEntryItem;
import au.com.apirosolutions.rates.scripting.PipelineJsonBase;

/**
 * a sample custom consolidate datapoint processor that doesn't do much
 */
public class AcmeConsDataPointSampleProcessor extends PipelineJsonBase<AcmeConsDataPointSampleProcessor.AcmeLogConfig> implements ConsDataPointProcessorIfc {

    @Override
    public void process(PipelineEngineContextIfc pec, AggregatedRateEntryItem aggregatedRateEntryItem, AggregatedRate aggregatedRate, AggregatedRate aggregatedRate1, RateDefinition rateDefinition, RateSchemaDefinition rateSchemaDefinition) {
        var cfg=getConfigObject(pec);
        System.out.println("========= >>> ACME CUSTOM LOG=============");
        System.out.println("message: "+cfg.message);
        System.out.println("========= <<< ACME CUSTOM LOG=============");
    }

    @Override
    public Class<AcmeLogConfig> getConfigClass() {
        return AcmeLogConfig.class;
    }

    @Override
    public void postConstruct() {
        //you can add postconstruct code here
    }

    @Override
    public void preDestroy() {
        //you can add predestroy code here
    }

    public static class AcmeLogConfig {
        public String message="default log message";
    }

}

