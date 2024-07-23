import 'package:logger/logger.dart';
import 'package:mobx/mobx.dart';

import 'entities/capture_source_type.dart';
import 'entities/exceptions.dart';

part 'sender.g.dart';

/// Implementation of the Model Sender class.
class Sender = _Sender with _$Sender;

abstract class _Sender with Store {
  final Logger _logger;

  // Determines whether the sender is running or not
  @observable
  bool _isStarted = false;

  @computed
  bool get isStarted => _isStarted;

  // Represents the active source port.
  @observable
  int _sourcePort = -1;

  @computed
  int get sourcePort => _sourcePort;

  // Represents the active repair port.
  @observable
  int _repairPort = -1;

  @computed
  int get repairPort => _repairPort;

  // Represents the active source port.
  @observable
  String _receiverIP = '';

  @computed
  String get receiverIP => _receiverIP;

  // Represents the user-selected capture source enum.
  @observable
  CaptureSourceType _captureSource =
      CaptureSourceType.currentlyPlayingApplications;

  @computed
  CaptureSourceType get captureSource => _captureSource;

  _Sender(Logger logger) : _logger = logger;

  // Start current sender.
  void start() {
    if (isStarted) {
      throw StartActiveSenderError;
    }

    _isStarted = !_isStarted;
    _logger.i('Sender started');
  }

  // Stop current sender.
  void stop() {
    if (!isStarted) {
      throw StopInactiveSenderError;
    }

    _isStarted = !_isStarted;
    _logger.i('Sender stopped');
  }

  // Update source port value
  @action
  void setSourcePort(int value) {
    _sourcePort = value;
    _logger.d('Sender source port value changed to: ${_sourcePort}');
  }

  // Update repair port value
  @action
  void setRepairPort(int value) {
    _repairPort = value;
    _logger.d('Sender repair port value changed to: ${_repairPort}');
  }

  // Update the active source port
  @action
  void setReceiverIP(String value) {
    _receiverIP = value;
    _logger.d('Sender active source port value changed to: ${_receiverIP}');
  }
}
