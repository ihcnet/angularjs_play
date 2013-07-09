
<g:set var="ImageSubPrefix" value="${subPrefix ? subPrefix + '.' : ''}"/>
    
    <div class="control-group" data-ng-class="{error: errors.${ImageSubPrefix}description}">
        <label class="control-label" for="${ImageSubPrefix}description">Description</label>
        <div class="controls">
            <input type="text" id="description" name="description" data-ng-model="item.${ImageSubPrefix}description">

            <span class="help-inline" data-ng-show="errors.${ImageSubPrefix}description">{{errors.${ImageSubPrefix}description}}</span>
        </div>
    </div>

    
