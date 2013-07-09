
<g:set var="DisplaySubPrefix" value="${subPrefix ? subPrefix + '.' : ''}"/>
    
    <div class="control-group" data-ng-class="{error: errors.${DisplaySubPrefix}screenResolution}">
        <label class="control-label" for="${DisplaySubPrefix}screenResolution">Screen Resolution</label>
        <div class="controls">
            <input type="text" id="screenResolution" name="screenResolution" data-ng-model="item.${DisplaySubPrefix}screenResolution">

            <span class="help-inline" data-ng-show="errors.${DisplaySubPrefix}screenResolution">{{errors.${DisplaySubPrefix}screenResolution}}</span>
        </div>
    </div>

    
    <div class="control-group" data-ng-class="{error: errors.${DisplaySubPrefix}screenSize}">
        <label class="control-label" for="${DisplaySubPrefix}screenSize">Screen Size</label>
        <div class="controls">
            <input type="text" id="screenSize" name="screenSize" data-ng-model="item.${DisplaySubPrefix}screenSize">

            <span class="help-inline" data-ng-show="errors.${DisplaySubPrefix}screenSize">{{errors.${DisplaySubPrefix}screenSize}}</span>
        </div>
    </div>

    
    <div class="control-group" data-ng-class="{error: errors.${DisplaySubPrefix}touchScreen}">
        <label class="control-label" for="${DisplaySubPrefix}touchScreen">Touch Screen</label>
        <div class="controls">
            <input type="checkbox" id="touchScreen" name="touchScreen" data-ng-model="item.${DisplaySubPrefix}touchScreen">

            <span class="help-inline" data-ng-show="errors.${DisplaySubPrefix}touchScreen">{{errors.${DisplaySubPrefix}touchScreen}}</span>
        </div>
    </div>

    
