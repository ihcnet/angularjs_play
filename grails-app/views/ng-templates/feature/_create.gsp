
<g:set var="FeatureSubPrefix" value="${subPrefix ? subPrefix + '.' : ''}"/>
    
    <div class="control-group" data-ng-class="{error: errors.${FeatureSubPrefix}description}">
        <label class="control-label" for="${FeatureSubPrefix}description">Description</label>
        <div class="controls">
            <input type="text" id="description" name="description" data-ng-model="item.${FeatureSubPrefix}description">

            <span class="help-inline" data-ng-show="errors.${FeatureSubPrefix}description">{{errors.${FeatureSubPrefix}description}}</span>
        </div>
    </div>

    
