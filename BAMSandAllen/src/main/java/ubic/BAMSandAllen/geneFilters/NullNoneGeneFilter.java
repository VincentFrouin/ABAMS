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

import ubic.basecode.dataStructure.matrix.DoubleMatrix;

public class NullNoneGeneFilter extends PrefixGeneFilter implements GeneFilter {
    public NullNoneGeneFilter() {
        super();
        prefixes.add( "null[" );
        prefixes.add( "none[" );
        removeMatches = true;
    }

    public String getName() {
        return "Null and None Gene remover";
    }

}
