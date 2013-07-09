
<g:set var="ConnectivitySubPrefix" value="${subPrefix ? subPrefix + '.' : ''}"/>
    
    <div class="control-group" data-ng-class="{error: errors.${ConnectivitySubPrefix}bluetooth}">
        <label class="control-label" for="${ConnectivitySubPrefix}bluetooth">Bluetooth</label>
        <div class="controls">
            <input type="text" id="bluetooth" name="bluetooth" data-ng-model="item.${ConnectivitySubPrefix}bluetooth">

            <span class="help-inline" data-ng-show="errors.${ConnectivitySubPrefix}bluetooth">{{errors.${ConnectivitySubPrefix}bluetooth}}</span>
        </div>
    </div>

    
    <div class="control-group" data-ng-class="{error: errors.${ConnectivitySubPrefix}cell}">
        <label class="control-label" for="${ConnectivitySubPrefix}cell">Cell</label>
        <div class="controls">
            <input type="text" id="cell" name="cell" data-ng-model="item.${ConnectivitySubPrefix}cell">

            <span class="help-inline" data-ng-show="errors.${ConnectivitySubPrefix}cell">{{errors.${ConnectivitySubPrefix}cell}}</span>
        </div>
    </div>

    
    <div class="control-group" data-ng-class="{error: errors.${ConnectivitySubPrefix}gps}">
        <label class="control-label" for="${ConnectivitySubPrefix}gps">Gps</label>
        <div class="controls">
            <input type="checkbox" id="gps" name="gps" data-ng-model="item.${ConnectivitySubPrefix}gps">

            <span class="help-inline" data-ng-show="errors.${ConnectivitySubPrefix}gps">{{errors.${ConnectivitySubPrefix}gps}}</span>
        </div>
    </div>

    
    <div class="control-group" data-ng-class="{error: errors.${ConnectivitySubPrefix}infrared}">
        <label class="control-label" for="${ConnectivitySubPrefix}infrared">Infrared</label>
        <div class="controls">
            <input type="checkbox" id="infrared" name="infrared" data-ng-model="item.${ConnectivitySubPrefix}infrared">

            <span class="help-inline" data-ng-show="errors.${ConnectivitySubPrefix}infrared">{{errors.${ConnectivitySubPrefix}infrared}}</span>
        </div>
    </div>

    
    <div class="control-group" data-ng-class="{error: errors.${ConnectivitySubPrefix}wifi}">
        <label class="control-label" for="${ConnectivitySubPrefix}wifi">Wifi</label>
        <div class="controls">
            <input type="text" id="wifi" name="wifi" data-ng-model="item.${ConnectivitySubPrefix}wifi">

            <span class="help-inline" data-ng-show="errors.${ConnectivitySubPrefix}wifi">{{errors.${ConnectivitySubPrefix}wifi}}</span>
        </div>
    </div>

    
