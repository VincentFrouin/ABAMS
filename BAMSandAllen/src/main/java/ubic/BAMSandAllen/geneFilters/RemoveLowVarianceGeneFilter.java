/*******************************************************************************
 * The ABAMS project
 * 
 * Copyright (c) 2012 University of British Columbia
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package ubic.BAMSandAllen.geneFilters;

import java.util.LinkedList;
import java.util.List;

import ubic.BAMSandAllen.Util;
import ubic.basecode.dataStructure.matrix.DoubleMatrix;

public class RemoveLowVarianceGeneFilter implements GeneFilter {

    double threshold;

    public RemoveLowVarianceGeneFilter( double threshold ) {
        super();
        this.threshold = threshold;
    }

    public String getName() {
        return "Low variance filter, threshold:" + threshold + " (not normalized by mean)";
    }

    public List<String> getRowsToRemove( DoubleMatrix<String, String> matrix ) {
        List<String> toRemove = new LinkedList<String>();

        for ( String rowName : matrix.getRowNames() ) {
            double[] row = matrix.getRowByName( rowName );
            double var = Util.variance( row );
            if ( var <= threshold ) {
                toRemove.add( rowName );
            }
        }
        return toRemove;
    }
}
