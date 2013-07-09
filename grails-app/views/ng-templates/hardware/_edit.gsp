
<g:set var="HardwareSubPrefix" value="${subPrefix ? subPrefix + '.' : ''}"/>
    
    <div class="control-group" data-ng-class="{error: errors.${HardwareSubPrefix}accelerometer}">
        <label class="control-label" for="${HardwareSubPrefix}accelerometer">Accelerometer</label>
        <div class="controls">
            <input type="checkbox" id="accelerometer" name="accelerometer" data-ng-model="item.${HardwareSubPrefix}accelerometer">

            <span class="help-inline" data-ng-show="errors.${HardwareSubPrefix}accelerometer">{{errors.${HardwareSubPrefix}accelerometer}}</span>
        </div>
    </div>

    
    <div class="control-group" data-ng-class="{error: errors.${HardwareSubPrefix}audioJack}">
        <label class="control-label" for="${HardwareSubPrefix}audioJack">Audio Jack</label>
        <div class="controls">
            <input type="text" id="audioJack" name="audioJack" data-ng-model="item.${HardwareSubPrefix}audioJack">

            <span class="help-inline" data-ng-show="errors.${HardwareSubPrefix}audioJack">{{errors.${HardwareSubPrefix}audioJack}}</span>
        </div>
    </div>

    
    <div class="control-group" data-ng-class="{error: errors.${HardwareSubPrefix}cpu}">
        <label class="control-label" for="${HardwareSubPrefix}cpu">Cpu</label>
        <div class="controls">
            <input type="text" id="cpu" name="cpu" data-ng-model="item.${HardwareSubPrefix}cpu">

            <span class="help-inline" data-ng-show="errors.${HardwareSubPrefix}cpu">{{errors.${HardwareSubPrefix}cpu}}</span>
        </div>
    </div>

    
    <div class="control-group" data-ng-class="{error: errors.${HardwareSubPrefix}fmRadio}">
        <label class="control-label" for="${HardwareSubPrefix}fmRadio">Fm Radio</label>
        <div class="controls">
            <input type="checkbox" id="fmRadio" name="fmRadio" data-ng-model="item.${HardwareSubPrefix}fmRadio">

            <span class="help-inline" data-ng-show="errors.${HardwareSubPrefix}fmRadio">{{errors.${HardwareSubPrefix}fmRadio}}</span>
        </div>
    </div>

    
    <div class="control-group" data-ng-class="{error: errors.${HardwareSubPrefix}physicalKeyboard}">
        <label class="control-label" for="${HardwareSubPrefix}physicalKeyboard">Physical Keyboard</label>
        <div class="controls">
            <input type="checkbox" id="physicalKeyboard" name="physicalKeyboard" data-ng-model="item.${HardwareSubPrefix}physicalKeyboard">

            <span class="help-inline" data-ng-show="errors.${HardwareSubPrefix}physicalKeyboard">{{errors.${HardwareSubPrefix}physicalKeyboard}}</span>
        </div>
    </div>

    
    <div class="control-group" data-ng-class="{error: errors.${HardwareSubPrefix}usb}">
        <label class="control-label" for="${HardwareSubPrefix}usb">Usb</label>
        <div class="controls">
            <input type="text" id="usb" name="usb" data-ng-model="item.${HardwareSubPrefix}usb">

            <span class="help-inline" data-ng-show="errors.${HardwareSubPrefix}usb">{{errors.${HardwareSubPrefix}usb}}</span>
        </div>
    </div>

    
