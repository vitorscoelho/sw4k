package vitorscoelho.sw4k.sapversions.v15.sapmodel.definitions.properties

import vitorscoelho.sw4k.sapversions.v14.sapmodel.definitions.properties.*
import vitorscoelho.sw4k.sapversions.v15.sapmodel.definitions.properties.propframe.SDShapeV15
import vitorscoelho.sw4k.sapversions.v15.sapmodel.definitions.properties.propmaterial.TimeDepV15

interface PropAreaV15 : PropAreaV14

interface PropCableV15 : PropCableV14

interface PropFrameV15 : PropFrameV14 {
    override val sdShape: SDShapeV15
}

interface PropLinkV15 : PropLinkV14

interface PropMaterialV15 : PropMaterialV14 {
    override val timeDep: TimeDepV15
}

interface PropSolidV15 : PropSolidV14

interface PropTendonV15 : PropTendonV14