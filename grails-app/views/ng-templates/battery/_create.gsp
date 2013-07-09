
<g:set var="BatterySubPrefix" value="${subPrefix ? subPrefix + '.' : ''}"/>
    
    <div class="control-group" data-ng-class="{error: errors.${BatterySubPrefix}standByTime}">
        <label class="control-label" for="${BatterySubPrefix}standByTime">Stand By Time</label>
        <div class="controls">
            <input type="text" id="standByTime" name="standByTime" data-ng-model="item.${BatterySubPrefix}standByTime">

            <span class="help-inline" data-ng-show="errors.${BatterySubPrefix}standByTime">{{errors.${BatterySubPrefix}standByTime}}</span>
        </div>
    </div>

    
    <div class="control-group" data-ng-class="{error: errors.${BatterySubPrefix}talkTime}">
        <label class="control-label" for="${BatterySubPrefix}talkTime">Talk Time</label>
        <div class="controls">
            <input type="text" id="talkTime" name="talkTime" data-ng-model="item.${BatterySubPrefix}talkTime">

            <span class="help-inline" data-ng-show="errors.${BatterySubPrefix}talkTime">{{errors.${BatterySubPrefix}talkTime}}</span>
        </div>
    </div>

    
    <div class="control-group" data-ng-class="{error: errors.${BatterySubPrefix}type}">
        <label class="control-label" for="${BatterySubPrefix}type">Type</label>
        <div class="controls">
            <input type="text" id="type" name="type" data-ng-model="item.${BatterySubPrefix}type">

            <span class="help-inline" data-ng-show="errors.${BatterySubPrefix}type">{{errors.${BatterySubPrefix}type}}</span>
        </div>
    </div>

    
